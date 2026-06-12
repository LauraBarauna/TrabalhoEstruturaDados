package infrastructure.report;

import com.lowagie.text.PageSize;
import domain.entities.RegistroAtendimento;
import domain.report.Relatorio;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import domain.structures.EstruturaVetor;
import infrastructure.structures.quickSort.ComparadorHorarioAtendimento;
import infrastructure.structures.quickSort.ComparadorTempoEspera;
import infrastructure.structures.quickSort.QuickSort;

import java.awt.Color;
import java.io.FileOutputStream;
import java.time.format.DateTimeFormatter;

public class PdfReport implements Relatorio {

    private Document document;

    private Font fonteTitulo;
    private Font fonteSubtitulo;
    private Font fonteTextoBold;
    private Font fonteTextoNormal;
    private Font fonteCabecalhoTabela;

    public PdfReport() {
        this.document = new Document(PageSize.A4, 36, 36, 36, 36);
        definirFontes();
    }

    @Override
    public void gerarRelatorio(EstruturaVetor<RegistroAtendimento> vetorGeral, EstruturaVetor<RegistroAtendimento> vetorPreferencial, EstruturaVetor<RegistroAtendimento>  vetorSoma) {
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Relatorio_Atendimentos.pdf"));
            this.document.open();

            Paragraph titulo = new Paragraph("Relatório de Desempenho de Atendimentos", this.fonteTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            document.add(titulo);

            gerarPrimeiraSecao(vetorGeral, vetorPreferencial);
            gerarTerceiraSecao(vetorSoma);
            System.out.println("Relatório PDF criado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.document.close();
        }

    }

    private void definirFontes() {
        this.fonteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, Color.DARK_GRAY);
        this.fonteSubtitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, new Color(41, 128, 185));
        this.fonteTextoBold = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, Color.BLACK);
        this.fonteTextoNormal = FontFactory.getFont(FontFactory.HELVETICA, 10, Color.BLACK);
        this.fonteCabecalhoTabela = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, Color.WHITE);
    }

    private void gerarPrimeiraSecao(EstruturaVetor<RegistroAtendimento> vetorGeral, EstruturaVetor<RegistroAtendimento> vetorPreferencial) {
        document.add(new Paragraph("1. Métricas de Desempenho Gerais", fonteSubtitulo));
        document.add(new Paragraph(" ", fonteTextoNormal));

        double esperaTotal = 0, esperaGeral = 0, esperaPrioritario = 0;
        int qtdNormal = vetorGeral.quantidade(), qtdPrioritario = vetorPreferencial.quantidade();

        for (int i = 0; i < vetorGeral.quantidade(); i++) {
            esperaTotal += vetorGeral.obterElemento(i).getTempoEsperaAtendimento();
            esperaGeral += vetorGeral.obterElemento(i).getTempoEsperaAtendimento();
        }

        for (int i = 0; i < vetorPreferencial.quantidade(); i++) {
            esperaTotal += vetorPreferencial.obterElemento(i).getTempoEsperaAtendimento();
            esperaPrioritario += vetorPreferencial.obterElemento(i).getTempoEsperaAtendimento();;
        }

        double mediaTotal = esperaTotal / (vetorGeral.quantidade() + vetorPreferencial.quantidade());
        double mediaNormal = qtdNormal > 0 ? esperaGeral / qtdNormal : 0;
        double mediaPrioritaria = qtdPrioritario > 0 ? esperaPrioritario / qtdPrioritario : 0;

        document.add(new Paragraph("• Tempo Médio de Espera Total: " + String.format("%.1f", mediaTotal) + " minutos", fonteTextoNormal));
        document.add(new Paragraph("• Tempo Médio de Espera (Atendimento Normal): " + String.format("%.1f", mediaNormal) + " minutos", fonteTextoNormal));
        document.add(new Paragraph("• Tempo Médio de Espera (Atendimento Prioritário): " + String.format("%.1f", mediaPrioritaria) + " minutos", fonteTextoNormal));
        document.add(new Paragraph(" ", fonteTextoNormal));

        gerarSegundaSecao(vetorGeral, vetorPreferencial);
    }

    private void gerarSegundaSecao(EstruturaVetor<RegistroAtendimento> vetorGeral, EstruturaVetor<RegistroAtendimento> vetorPreferencial) {
        document.add(new Paragraph("2. Total de Atendimentos por Guichê", this.fonteSubtitulo));
        document.add(new Paragraph(" ", this.fonteTextoNormal));

        PdfPTable tabelaGuiches = new PdfPTable(4);
        tabelaGuiches.setWidthPercentage(100);
        tabelaGuiches.setSpacingAfter(20);

        String[] cabecalhosGuiche = {"Guichê", "Qtd. Normal", "Qtd. Prioritário", "Total Atendimentos"};
        for (String col : cabecalhosGuiche) {
            PdfPCell cell = new PdfPCell(new Paragraph(col, this.fonteCabecalhoTabela));
            cell.setBackgroundColor(new Color(41, 128, 185));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(6);
            tabelaGuiches.addCell(cell);
        }

        int qtdPreferencial = 0;
        int qtdGeral = 0;
        for (int i = 0; i < vetorGeral.quantidade(); i++) {
            RegistroAtendimento registro = vetorGeral.obterElemento(i);
            if (registro.getCliente().isPrioritario()) {
                qtdPreferencial++;
            } else {
                qtdGeral++;
            }
        }

        tabelaGuiches.addCell(new PdfPCell(new Paragraph("Guichê Geral", fonteTextoNormal)));
        tabelaGuiches.addCell(new PdfPCell(new Paragraph(String.valueOf(qtdGeral), fonteTextoNormal)));
        tabelaGuiches.addCell(new PdfPCell(new Paragraph(String.valueOf(qtdPreferencial), fonteTextoNormal)));
        tabelaGuiches.addCell(new PdfPCell(new Paragraph(String.valueOf(qtdGeral + qtdPreferencial), fonteTextoNormal)));

        qtdPreferencial = 0;
        qtdGeral = 0;
        for (int i = 0; i < vetorPreferencial.quantidade(); i++) {
            RegistroAtendimento registro = vetorPreferencial.obterElemento(i);
            if (registro.getCliente().isPrioritario()) {
                qtdPreferencial++;
            } else {
                qtdGeral++;
            }
        }

        tabelaGuiches.addCell(new PdfPCell(new Paragraph("Guichê Preferêncial", fonteTextoNormal)));
        tabelaGuiches.addCell(new PdfPCell(new Paragraph(String.valueOf(qtdGeral), fonteTextoNormal)));
        tabelaGuiches.addCell(new PdfPCell(new Paragraph(String.valueOf(qtdPreferencial), fonteTextoNormal)));
        tabelaGuiches.addCell(new PdfPCell(new Paragraph(String.valueOf(qtdGeral + qtdPreferencial), fonteTextoNormal)));

        document.add(tabelaGuiches);
    }

    private void gerarTerceiraSecao(EstruturaVetor<RegistroAtendimento>  vetorSoma) {
        document.add(new Paragraph("3. Relação Detalhada de Atendimentos", this.fonteSubtitulo));
        document.add(new Paragraph(" ", this.fonteTextoNormal));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        QuickSort<RegistroAtendimento> sorter = new QuickSort<>();

        document.add(new Paragraph("3.1 Ordenado por Ordem Crescente de Tempo de Espera", this.fonteTextoBold));
        document.add(new Paragraph(" ", this.fonteTextoNormal));

        sorter.ordenar(vetorSoma, new ComparadorTempoEspera());

        document.add(gerarTabelaAtendimentos(vetorSoma, fonteCabecalhoTabela, fonteTextoNormal, formatter));
        document.add(new Paragraph(" ", fonteTextoNormal));

        document.add(new Paragraph("3.2 Ordenado por Ordem Cronológica (Horário)", fonteTextoBold));
        document.add(new Paragraph(" ", fonteTextoNormal));
        sorter.ordenar(vetorSoma, new ComparadorHorarioAtendimento());
        document.add(gerarTabelaAtendimentos(vetorSoma, fonteCabecalhoTabela, fonteTextoNormal, formatter));
        document.add(new Paragraph(" ", fonteTextoNormal));

    }

    private static PdfPTable gerarTabelaAtendimentos(EstruturaVetor<RegistroAtendimento> vetorGeral, Font fCabecalho, Font fTexto, DateTimeFormatter fmt) {
        PdfPTable tabela = new PdfPTable(8);
        tabela.setWidthPercentage(100);

        String[] cabecalhos = {"ID", "Cliente", "Idade", "Guichê", "Tipo", "Horario Entrada", "Horário Atendimento", "Tempo de Espera"};
        for (String col : cabecalhos) {
            PdfPCell cell = new PdfPCell(new Paragraph(col, fCabecalho));
            cell.setBackgroundColor(new Color(52, 73, 94));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(5);
            tabela.addCell(cell);
        }

        popularColunas(vetorGeral, fTexto, fmt, tabela);


        return tabela;
    }

    private static void popularColunas(EstruturaVetor<RegistroAtendimento> vetor, Font fTexto, DateTimeFormatter fmt, PdfPTable tabela) {
        for (int i = 0; i < vetor.quantidade(); i++) {
            RegistroAtendimento registro = vetor.obterElemento(i);

            String gc = "1";
            String tipo = "Geral";

            if (registro.getCliente().isPrioritario()) {
                gc = "2";
                tipo = "Preferêncial";
            }

            tabela.addCell(new PdfPCell(new Paragraph(String.valueOf(registro.getCliente().getId()), fTexto)));
            tabela.addCell(new PdfPCell(new Paragraph(registro.getCliente().getNome(), fTexto)));
            tabela.addCell(new PdfPCell(new Paragraph(String.valueOf(registro.getCliente().getIdade()), fTexto)));
            tabela.addCell(new PdfPCell(new Paragraph(gc, fTexto)));
            tabela.addCell(new PdfPCell(new Paragraph(tipo, fTexto)));
            tabela.addCell(new PdfPCell(new Paragraph(registro.getHorarioEntrada().format(fmt), fTexto)));
            tabela.addCell(new PdfPCell(new Paragraph(registro.getHorarioInicio().format(fmt), fTexto)));
            tabela.addCell(new PdfPCell(new Paragraph(registro.getTempoEsperaAtendimento() + " min", fTexto)));
        }
    }


}
