package br.com.luigipietro.citiesapi.tools;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CreateCitySql {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Alano\\Voltar para o OneDrive\\MonteGrappa\\Workspace-Java\\DIO-Java\\SQL-cidades\\sql-paises-estados-cidades\\PostgreSQL";
        String nomeArq = "cidades.csv";
        String row;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(
                path + "\\" + nomeArq), "UTF-8"));

        FileWriter fw = new FileWriter(new File(path + "\\new" + nomeArq), StandardCharsets.UTF_8);
        BufferedWriter writer = new BufferedWriter(fw);

        while ((row = br.readLine()) != null){
            String[] columns = row.split("#");

            System.out.println("Lendo cidade " + columns[1]);

            writer.append("(");
            writer.append(columns[0]);   writer.append(",'");
            writer.append(columns[1]);   writer.append("',");
            writer.append(columns[2]);   writer.append(",");
            writer.append(columns[3]);   writer.append(",'");
            writer.append(columns[4]);   writer.append("',");
            writer.append(columns[5]);   writer.append(",");
            writer.append(columns[6]);   writer.append(",");
            writer.append(columns[7]);   writer.append("),\n");

        }

        writer.flush();
        writer.close();
        br.close();
    }
}
