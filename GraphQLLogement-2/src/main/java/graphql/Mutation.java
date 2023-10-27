package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entity.Logement;
import entity.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

public class Mutation implements GraphQLRootResolver {
    public LogementRepository repoLogement;
    public RendezVousRepository reporendez;

    public Mutation(LogementRepository repoLogement, RendezVousRepository reporendez) {
        this.repoLogement = repoLogement;
        this.reporendez = reporendez;
    }

    public Boolean createRendezVous(int id,String date,String heure,int refLogement,String numTel){
        Logement l=repoLogement.getLogementsByReference(refLogement);
        RendezVous rendezVous=new RendezVous(id,date,heure,l,numTel);
        return reporendez.addRendezVous(rendezVous);
    }
    public Boolean updateRendezVous(int id,String date,String heure,String numTel){
        Logement l=reporendez.getLogementByRDV(id);
        RendezVous rendezVous=new RendezVous(id,date,heure,l,numTel);
        return reporendez.updateRendezVous(rendezVous);
    }
    public String deleteRendezVous(int id){
        if(reporendez.deleteRendezVous(id))
            return "Deleted";
        return "failed";

    }
    public Boolean createLogement(int reference,String adresse){
        Logement l=new Logement(reference,adresse);
        return repoLogement.saveLogement(l);
    }


}
