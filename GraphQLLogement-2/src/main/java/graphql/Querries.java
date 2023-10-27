package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entity.Logement;
import entity.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;
import entity.Logement.Type;

import java.util.List;

public class Querries implements GraphQLRootResolver {
    public LogementRepository repoLogement;
    public RendezVousRepository reporendez;

    public Querries(LogementRepository repoLogement,RendezVousRepository reporendez) {
        this.repoLogement = repoLogement;
        this.reporendez = reporendez;
    }

    public List<Logement> allLogements(){
        return repoLogement.getAllLogements();
    }
    public List<RendezVous> allRendezVous(){return reporendez.getListeRendezVous();}
    public RendezVous getRendezVoussById(int id){
        return reporendez.getRendezVoussById(id);
    }
    public List<Logement> getLogementsByType(Type type){
        return repoLogement.getLogementsByType(type);
    }
    public Logement getLogementsByReference(int reference){
        return repoLogement.getLogementsByReference(reference);
    }
}
