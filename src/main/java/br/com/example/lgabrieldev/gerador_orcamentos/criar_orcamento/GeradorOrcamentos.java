package br.com.example.lgabrieldev.gerador_orcamentos.criar_orcamento;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import br.com.example.lgabrieldev.gerador_orcamentos.models.item.Item;
import br.com.example.lgabrieldev.gerador_orcamentos.models.orcamento.Orcamento;

@Component
public class GeradorOrcamentos {

    //attributes
    String filePath = "/mnt/c/Users/leekbiel/Desktop/testeNovo.xlsm";


    // ============ criar orcamento ============
    public String criarOrcamento(Orcamento dadosOrcamento){

        //verificamos se o arquivo existe
        this.arquivoExiste(filePath);

        //preenchemos planilha dados (1)
        try{
            this.preencherPlanilhaDados(dadosOrcamento);
        }
        catch(Exception e){
            throw new RuntimeException(" erro aconteceu no method criarOrcamento()");
        }

        //preenchemos planilha dashboard (0)
        

        return "Orcamento criado com sucesso!";
    }
    
    
    // ============ verificar se o arquivo existe ============
    public Boolean arquivoExiste(String filepath){
        try{
            FileInputStream fis = new FileInputStream(filePath);
            fis.close();
        }
        catch(IOException e){
            throw new RuntimeException("Arquivo não encontrado --> ".concat(this.filePath));
        }
        return true;
    }


     // ========== alterar os dados da planilha (1) DADOS ==========
     public Workbook preencherPlanilhaDados(Orcamento dadosOrcamento) throws Exception{
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);

        // ========== Planilha dos dados (1) ==========
        Sheet sheetDados = workbook.getSheetAt(1);

        //orcamento number
        Cell lastOrcamentoNumberCell = sheetDados.getRow(1).getCell(1);
        Double atualOrcamentoNumber = (lastOrcamentoNumberCell.getNumericCellValue() + 1);
        lastOrcamentoNumberCell.setCellValue(atualOrcamentoNumber);

        //date
        // Cell todayCell = sheetDados.getRow(3).getCell(1);
        // todayCell.setCellValue(dadosOrcamento.getDataEnvio());

        //orcamentoNumber + date
        Cell cellOrcamentoNumbe = sheetDados.getRow(2).getCell(1);
        String orcamentoNumberPlusDate = String.format("Orçamento #%.0f/%d\n%s", atualOrcamentoNumber, LocalDate.now().getYear(), dadosOrcamento.getDataEnvio());
        cellOrcamentoNumbe.setCellValue(orcamentoNumberPlusDate);

        //cliente
        Cell clienteCell = sheetDados.getRow(4).getCell(1);
        clienteCell.setCellValue(dadosOrcamento.getCliente());

        //descricao
        Cell descricaoRowCell = sheetDados.getRow(5).getCell(1);
        descricaoRowCell.setCellValue(dadosOrcamento.getDescricao());

        //observacoes
        Cell observacoesCell = sheetDados.getRow(6).getCell(1);
        observacoesCell.setCellValue(dadosOrcamento.getObservacoes());

        //forma de pagamento
        String formaDePagamento = "";
        if(dadosOrcamento.getSinal() != 0){
            formaDePagamento = String.format("Sinal de R$ %s + %dx de R$ %s no cartão", dadosOrcamento.getSinal(), dadosOrcamento.getParcelas(), dadosOrcamento.getCalcularParcela());
        }
        Cell formaDePagamentoCell = sheetDados.getRow(7).getCell(1);
        formaDePagamentoCell.setCellValue(formaDePagamento);
        
        //prazo de entrega
        Cell prazoDeEntregaCell = sheetDados.getRow(8).getCell(1);
        prazoDeEntregaCell.setCellValue(dadosOrcamento.getPrazoEntrega() + " dias");


        //salvamos o arquivo
        try(FileOutputStream fos = new FileOutputStream(this.filePath)){
            workbook.write(fos);
        }

        
        return workbook;
     }


    //method para criar orcamento
    public void preencherPlanilhaDashBoard(Workbook workbook, Orcamento dadosOrcamento) throws Exception{

            // ========== Planilha do dashboard (0)  ==========
            Sheet orcamentSheet = workbook.getSheetAt(0);

            //rows do dashboard
            Row rowItem1 = orcamentSheet.getRow(16);
            Row rowItem2 = orcamentSheet.getRow(18);
            Row rowItem3 = orcamentSheet.getRow(20);
            Row rowItem4 = orcamentSheet.getRow(22);
            Row rowItem5 = orcamentSheet.getRow(24);
            Row rowItem6 = orcamentSheet.getRow(26);

            List<Row> rowsOrcamentoItems = List.of(rowItem1, rowItem2, rowItem3, rowItem4, rowItem5, rowItem6);
            List<Item> items = dadosOrcamento.getItems();

            //alteramos os dados da row atual
            for(int i = 0; i < rowsOrcamentoItems.size(); i++){

                Item itemAtual = items.get(i);
                Row rowAtual = rowsOrcamentoItems.get(i);

                rowAtual.getCell(1).setCellValue(itemAtual.getDescricao());
                rowAtual.getCell(2).setCellValue(itemAtual.getValorUnit());
                rowAtual.getCell(3).setCellValue(itemAtual.getQuantity());
                rowAtual.getCell(4).setCellValue(itemAtual.getValorTotal());

                //definimos a altura dessas row  
                rowsOrcamentoItems.get(i).setHeight((short) (90 * 20));    
            }

            //total
            Cell totalCell = orcamentSheet.getRow(29).getCell(4);
            totalCell.setCellValue(dadosOrcamento.getValorTotal());


            // //stilo de alinhamento em cima
            // // CellStyle alinharEmCima = workbook.getCellStyleAt(0);
            // // alinharEmCima.setVerticalAlignment(VerticalAlignment.TOP);

            // //alteramos o arquivo
            // try(FileOutputStream fos = new FileOutputStream(filePathNovo)){
            //     workbook.write(fos);
            // }

            //salvamos o arquivo
            try(FileOutputStream fos = new FileOutputStream(this.filePath)){
                workbook.write(fos);
            }
    }
}
