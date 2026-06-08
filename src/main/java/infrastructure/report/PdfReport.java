package infrastructure.report;

import com.lowagie.text.PageSize;
import domain.entities.RegistroAtendimento;
import domain.report.Report;
import domain.structures.EstruturaDados;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Color;
import java.io.FileOutputStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PdfReport implements Report {

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
    public void gerarRelatorio(EstruturaDados<RegistroAtendimento> pilhaGeral, EstruturaDados<RegistroAtendimento> pilhaPreferencial) {
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Relatorio_Atendimentos.pdf"));
            this.document.open();

            Paragraph titulo = new Paragraph("Relatório de Desempenho de Atendimentos", this.fonteTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            document.add(titulo);

            gerarPrimeiraSecao(pilhaGeral, pilhaPreferencial);


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

    private void gerarPrimeiraSecao(EstruturaDados<RegistroAtendimento> pilhaGeral, EstruturaDados<RegistroAtendimento> pilhaPreferencial) {
        document.add(new Paragraph("1. Total de Atendimentos por Guichê", this.fonteSubtitulo));
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

        String[] listaDeGuiches = {"Guichê Geral", "Guichê Preferêncial"};
        for (String g : listaDeGuiches) {
            tabelaGuiches.addCell(new PdfPCell(new Paragraph(g, fonteTextoNormal)));
            tabelaGuiches.addCell(new PdfPCell(new Paragraph(String.valueOf(pilhaGeral.quantidade()), fonteTextoNormal)));
            tabelaGuiches.addCell(new PdfPCell(new Paragraph(String.valueOf(pilhaPreferencial.quantidade()), fonteTextoNormal)));
            tabelaGuiches.addCell(new PdfPCell(new Paragraph(String.valueOf(pilhaGeral.quantidade() + pilhaPreferencial.quantidade()), fonteTextoNormal)));
        }



    }

    private void gerarSegundaSecao(EstruturaDados<RegistroAtendimento> pilhaGeral, EstruturaDados<RegistroAtendimento> pilhaPreferencial) {
        document.add(new Paragraph("1. Métricas de Desempenho Gerais", fonteSubtitulo));
        document.add(new Paragraph(" ", fonteTextoNormal));

        double esperaTotal = 0, esperaGeral = 0, esperaPrioritario = 0;
        int qtdNormal = 0, qtdPrioritario = 0;

        while (!pilhaGeral.estaVazia()) {

        }

    }

}
