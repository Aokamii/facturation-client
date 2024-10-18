package com.example;

public class ClientParticulier extends Client {
    private String civilite;
    private String nom;
    private String prenom;

    public ClientParticulier(String referenceClient, double consommationElectricite, double consommationGaz, String civilite, String nom, String prenom) {
        super(referenceClient, consommationElectricite, consommationGaz);
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public double calculerFacture() {
        return calculerFacture(ClientUtils.PRIX_ELECTRICITE_PARTICULIER, ClientUtils.PRIX_GAZ_PARTICULIER);
    }
}

