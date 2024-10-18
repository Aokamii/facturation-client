package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ClientTest {

    @Test
    public void testCalculFactureClientParticulier() {
        ClientParticulier particulier = new ClientParticulier("EKW12345678", 100, 100, "Monsieur", "Dupont", "Jean");
        double montant = particulier.calculerFacture();
        assertEquals(23.6, montant, 0.01);
    }

    @Test
    public void testCalculFactureClientProCAInfSeuil() {
        ClientPro pro = new ClientPro("EKW87654321", 100, 100, "12345678901234", "Entreprise X", ClientUtils.SEUIL_PRO - 1);
        double montant = pro.calculerFacture();
        assertEquals(23.1, montant, 0.01);
    }

    @Test
    public void testCalculFactureClientProCASupSeuil() {
        ClientPro pro = new ClientPro("EKW87654321", 100, 100, "12345678901234", "Entreprise Y", ClientUtils.SEUIL_PRO + 1);
        double montant = pro.calculerFacture();
        assertEquals(22.5, montant, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReferenceClientInvalideText() {
        new ClientParticulier("ABC12345678", 100, 100, "Monsieur", "Dupont", "Jean");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReferenceClientInvalideLongueur() {
        new ClientParticulier("EKW1234567", 100, 100, "Monsieur", "Dupont", "Jean");
    }
}
