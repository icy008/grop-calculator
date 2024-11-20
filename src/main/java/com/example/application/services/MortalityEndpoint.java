package com.example.application.services;

import org.springframework.stereotype.Service;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;

@BrowserCallable
@AnonymousAllowed
@Service
public class MortalityEndpoint {

        // Endpoint method that calculates the mortality rates
        public MortalityResult calculateMortality(double totalPoints) {
            double oneYearMortalityConstantVal = 0.77921;
            double threeYearMortalityConstantVal = 0.51646;
            double constantValue = 1.37464;
    

            double exponent = totalPoints - constantValue;
            double oneYearMortality = (1 - Math.pow(oneYearMortalityConstantVal, exponent)) * 100;
            double threeYearMortality = (1 - Math.pow(threeYearMortalityConstantVal, exponent)) * 100;
            
            // Ensure no negative values
            oneYearMortality = Math.max(0, oneYearMortality);
            threeYearMortality = Math.max(0, threeYearMortality);

            return new MortalityResult(oneYearMortality, threeYearMortality);
        }

        // Inner class to encapsulate the mortality results
        public static class MortalityResult {
            private final double oneYearMortality;
            private final double threeYearMortality;

            public MortalityResult(double oneYearMortality, double threeYearMortality) {
                this.oneYearMortality = oneYearMortality;
                this.threeYearMortality = threeYearMortality;
            }

            public double getOneYearMortality() {
                return oneYearMortality;
            }

            public double getThreeYearMortality() {
                return threeYearMortality;
            }
        }
}
