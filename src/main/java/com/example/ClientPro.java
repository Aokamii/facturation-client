package com.example;

public class ClientPro extends Client {
    private String numeroSIRET;
    private String raisonSociale;
    private double chiffreAffaires;

    public ClientPro(String referenceClient, double consommationElectricite, double consommationGaz, String numeroSIRET, String raisonSociale, double chiffreAffaires) {
        super(referenceClient, consommationElectricite, consommationGaz);
        this.numeroSIRET = numeroSIRET;
        this.raisonSociale = raisonSociale;
        this.chiffreAffaires = chiffreAffaires;
    }

    @Override
    public double calculerFacture() {
        double prixElectricite;
        double prixGaz;
        if(chiffreAffaires > ClientUtils.SEUIL_PRO) {
            prixElectricite = ClientUtils.PRIX_ELECTRICITE_PRO_SUPERIEUR_SEUIL;
            prixGaz = ClientUtils.PRIX_GAZ_PRO_SUPERIEUR_SEUIL;
        } else {
            prixElectricite = ClientUtils.PRIX_ELECTRICITE_PRO_INFERIEUR_SEUIL;
            prixGaz = ClientUtils.PRIX_GAZ_PRO_INFERIEUR_SEUIL;
        }
        
        return calculerFacture(prixElectricite, prixGaz);
    }
}
