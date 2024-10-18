package com.example;

import lombok.Getter;

public abstract class Client {
    @Getter
    protected String referenceClient;
    protected double consommationElectricite;
    protected double consommationGaz;

    public Client(String referenceClient, double consommationElectricite, double consommationGaz) {
        if (!referenceClient.matches("EKW\\d{8}")) {
            throw new IllegalArgumentException("Référence client invalide.");
        }
        this.referenceClient = referenceClient;
        this.consommationElectricite = consommationElectricite;
        this.consommationGaz = consommationGaz;
    }

    /**
     * Calcul le montant de la facture pour le client
     * @return le montant de la facture
     */
    public abstract double calculerFacture();

    /**
     * Méthode utilitaire faisant le calcul en fonction des prix au kWh fournis en paramètre
     * @param prixElectricite Le prix de l'électricite au kWh, dépendant du profil client
     * @param prixGaz Le prix du gaz au kWh, dépendant du profil client
     * @return l'addition des prix calculés pour la consommation électrique et la consommation de gaz
     */
    protected double calculerFacture(double prixElectricite, double prixGaz){
        return (consommationElectricite * prixElectricite) + (consommationGaz * prixGaz);
    }
}
