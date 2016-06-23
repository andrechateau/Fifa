/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.gcc110.s2016_01.trabalho1.desOrientados.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import br.ufla.dcc.gcc110.s2016_01.trabalho1.desOrientados.models.Jogador;
import br.ufla.dcc.gcc110.s2016_01.trabalho1.desOrientados.models.Partida;
import br.ufla.dcc.gcc110.s2016_01.trabalho1.desOrientados.models.Time;
import java.io.FileOutputStream;

/**
 *
 * @author Andre Chateaubriand
 */
public class FileHandler {

    private final String FILE_NAME;
    private final String PRE_FILE_NAME;
    private Save save;
    private Save presave;

    FileHandler(String filename) {
        FILE_NAME = filename + ".fsave";
        PRE_FILE_NAME = "pre_" + filename + ".fsave";
        update();
    }

    /**
     * Atualiza os arquivos carregados.
     *
     */
    private void update() {
        updatePreSave();
        updateSave();
    }

    private void updatePreSave() {
        presave = new Save();
        try {
            FileInputStream finput = new FileInputStream(PRE_FILE_NAME);
            ObjectInputStream ostr = new ObjectInputStream(finput);
            presave = (Save) ostr.readObject();
            ostr.close();
            if (presave.getPartidaList() == null) {
                presave.setPartidaList(new ArrayList<>());
            }
            if (presave.getTimeList() == null) {
                presave.setTimeList(new ArrayList<>());
            }
        } catch (FileNotFoundException ex) {
            presave.setPartidaList(new ArrayList<>());
            presave.setTimeList(new ArrayList<>());
            createEmptyPreSave();
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateSave() {
        save = new Save();
        try {
            FileInputStream finput = new FileInputStream(FILE_NAME);
            ObjectInputStream ostr = new ObjectInputStream(finput);
            save = (Save) ostr.readObject();
            ostr.close();
            if (save.getPartidaList() == null) {
                save.setPartidaList(new ArrayList<>());
            }
            if (save.getTimeList() == null) {
                save.setTimeList(new ArrayList<>());
            }
        } catch (FileNotFoundException ex) {
            save.setPartidaList(new ArrayList<>());
            save.setTimeList(new ArrayList<>());
            createEmptySave();
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void preSave(Time time) {
        update();
        boolean changed = false;
        ArrayList<Time> timeList = presave.getTimeList();
        for (int i = 0; i < timeList.size(); i++) {
            if (time.getID() == timeList.get(i).getID()) {
                timeList.set(i, time);
                changed = true;
            }
        }
        if (!changed) {
            timeList.add(time);
        }
        presave.setTimeList(timeList);
        savePreSave();

    }

    public void preSave(Partida partida) {
        update();
        boolean changed = false;
        ArrayList<Partida> partidaList = presave.getPartidaList();
        for (int i = 0; i < partidaList.size(); i++) {
            if (partida.getID() == partidaList.get(i).getID()) {
                partidaList.set(i, partida);
                changed = true;
            }
        }
        if (!changed) {
            partidaList.add(partida);
        }
        presave.setPartidaList(partidaList);
        savePreSave();
    }

    private void savePreSave() {
        try {
            File file = new File(PRE_FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fout = new FileOutputStream(file);
            ObjectOutputStream ostr = new ObjectOutputStream(fout);
            ostr.writeObject(presave);
            ostr.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileHandler.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void mergePreSave() {
        update();
        save = mergeTimeList(presave, save);
        save = mergePartidaList(presave, save);

    }

    private void clearPreSave() {
        presave = new Save();
        presave.setPartidaList(new ArrayList<>());
        presave.setTimeList(new ArrayList<>());
    }

    private void clearSave() {
        save = new Save();
        save.setPartidaList(new ArrayList<>());
        save.setTimeList(new ArrayList<>());
    }

    public void clearAll() {
        clearPreSave();
        clearSave();
        createEmptySave();
        createEmptyPreSave();
    }

    private void createEmptySave() {
        Save tempSave = new Save();
        tempSave.setPartidaList(new ArrayList<>());
        tempSave.setTimeList(new ArrayList<>());
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fout = new FileOutputStream(file);
            ObjectOutputStream ostr = new ObjectOutputStream(fout);
            ostr.writeObject(tempSave);
            ostr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileHandler.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createEmptyPreSave() {
        Save tempSave = new Save();
        tempSave.setPartidaList(new ArrayList<>());
        tempSave.setTimeList(new ArrayList<>());
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fout = new FileOutputStream(file);
            ObjectOutputStream ostr = new ObjectOutputStream(fout);
            ostr.writeObject(tempSave);
            ostr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileHandler.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save() {
        mergePreSave();
        clearPreSave();
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fout = new FileOutputStream(file);
            ObjectOutputStream ostr = new ObjectOutputStream(fout);
            ostr.writeObject(save);
            ostr.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileHandler.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Save mergeTimeList(Save a, Save b) {
        ArrayList<Time> listA = new ArrayList<>();
        listA.clear();
        listA.addAll(a.getTimeList());
        ArrayList<Time> listB = new ArrayList<>();;
        listB.clear();
        listB.addAll(b.getTimeList());
        boolean merged;
        for (int i = 0; i < listA.size(); i++) {
            merged = false;
            for (int j = 0; j < listB.size(); j++) {
                if (listA.get(i).getID() == listB.get(j).getID()) {
                    listB.set(j, listA.get(i));
                    merged = true;
                }
            }
            if (!merged) {
                listB.add(listA.get(i));
            }
        }
        b.setTimeList(listB);
        return b;
    }

    private Save mergePartidaList(Save a, Save b) {
        ArrayList<Partida> listA = new ArrayList<>();
        listA.clear();
        listA.addAll(a.getPartidaList());
        ArrayList<Partida> listB = new ArrayList<>();
        listB.clear();
        listB.addAll(b.getPartidaList());
        boolean merged;
        for (int i = 0; i < listA.size(); i++) {
            merged = false;
            for (int j = 0; j < listB.size(); j++) {
                if (listA.get(i).getID() == listB.get(j).getID()) {
                    listB.set(j, listA.get(i));
                    merged = true;
                }
            }
            if (!merged) {
                listB.add(listA.get(i));
            }
        }
        b.setPartidaList(listB);
        return b;
    }

    public ArrayList<Time> getTimeList() {
        update();
        Save saveTemp = mergeTimeList(presave, save);
        return saveTemp.getTimeList();
    }

    public ArrayList<Partida> getPartidaList() {
        update();
        Save saveTemp = mergePartidaList(presave, save);
        return saveTemp.getPartidaList();
    }
}
