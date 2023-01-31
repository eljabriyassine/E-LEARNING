package ClasseMetier;

import java.io.Serializable;

public class Classe implements Serializable {
    private int id_classe;
    private int id_responsable;

    private String name;
    private String description;

    public Classe(int id_classe, int id_responsable, String name, String description) {
        this.id_classe = id_classe;
        this.id_responsable = id_responsable;
        this.name = name;
        this.description = description;
    }

    public Classe(int idProf, String nameClasse, String description) {
        this.id_responsable=idProf;
        this.name= nameClasse;
        this.description= description;
    }


    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public int getId_responsable() {
        return id_responsable;
    }

    public void setId_responsable(int id_responsable) {
        this.id_responsable = id_responsable;
    }

    public String getName() {
        return name;
    }

    public void setNom(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
