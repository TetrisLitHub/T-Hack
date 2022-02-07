package com.TheTetrisDude.T_Hack.config;

import com.TheTetrisDude.T_Hack.util.Reference;
import net.minecraft.client.Minecraft;

import java.io.*;
import java.util.ArrayList;

public class SaveLoader {
    private File directory;

    public SaveLoader() {
        directory = new File(Minecraft.getMinecraft().gameDir, Reference.NAME);
        if (!directory.exists()) directory.mkdir();
    }

    public void save(ArrayList<String> arrayList, String filename) {
        try {
            File file = new File(directory, filename + ".thcf");
            if (!file.exists()) try { file.createNewFile(); } catch (IOException e) { e.printStackTrace(); }
            PrintWriter writer = new PrintWriter(file);
            for (String string : arrayList) writer.println(string);
            writer.close();
        } catch (FileNotFoundException e) { e.printStackTrace(); }
    }

    public void load(ArrayList<String> lines, String filename) {
        try {
            File file = new File(directory, filename + ".thcf");
            if (!file.exists()) try { file.createNewFile(); } catch (IOException e) { e.printStackTrace(); }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while(line != null) {
                lines.add(line);
                line = reader.readLine();
            } reader.close();
        } catch(Exception e) { e.printStackTrace(); }
    }

}
