/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author patte
 */
import java.io.*;
import javax.swing.table.DefaultTableModel;
public class Inventory {
    private File logs;
    private TableTest tbt;
    public Inventory(){
        logs = new File("database.txt");
        try{
            logs.createNewFile();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public void loadFile(){
        try{
            FileReader fr = new FileReader(logs);
            BufferedReader br = new BufferedReader(fr);
            DefaultTableModel model = (DefaultTableModel)tbt.getTable1().getModel();
            Object[] line = br.lines().toArray();
            for(int i = 0; i < line.length; i++){
                String[] row = line[i].toString().split("|");
                model.addRow(row);
            }
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
    public void saveFile(){
        try{
            FileWriter fw = new FileWriter(logs);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i = 0; i < tbt.getTable1().getRowCount(); i++){//row
                for(int j = 0; j < tbt.getTable1().getColumnCount(); j++){
                    bw.write(tbt.getTable1().getValueAt(i, j).toString()+"|");
                }
                bw.newLine();
            }
            bw.close();
            fw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        } 
    }
    public File getFile(){
        return logs;
    }
}
