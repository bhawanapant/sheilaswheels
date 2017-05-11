package com.sheilaswheels.domain;

import com.sheilaswheels.domain.enumType.BoostCover;
import com.sheilaswheels.domain.enumType.BreakdownOptions;
import lombok.Builder;
import lombok.Data;

import static com.sheilaswheels.domain.enumType.BoostCover.MOTORLEGALPROTECTION;

/**
 * Created by bhawana on 09/05/2017.
 */
@Builder
@Data
public class YourQuote {
    private BoostInsuranceCover boostInsuranceCover;
    private BreakdownOption breakdownOption;

        public static class YourQuoteBuilder{
            private BoostInsuranceCover boostInsuranceCover = BoostInsuranceCover.builder().build();
            private BreakdownOption breakdownOption = BreakdownOption.builder().build();
        }
        @Builder
        @Data
        public static class BoostInsuranceCover{
            private double monthlyCost;
            private double annualPremium;
            private BoostCover boostCover;
            private boolean ncdProtection;

            public static class BoostInsuranceCoverBuilder{
                private double monthlyCost = 0.0;
                private double annualPremium = 0.0;
                private BoostCover boostCover = MOTORLEGALPROTECTION;
                private boolean ncdProtection = false;
            }
        }
        @Builder
        @Data
        public static class BreakdownOption{
            private BreakdownOption breakdownOption;

        public static class BreakdownOptionBuilder{
            private BreakdownOptions breakdownOptions = BreakdownOptions.RSA_HR_RECOVERY;
        }
    }
}
