package com.example.bikeshop.sevices;

import org.junit.jupiter.api.Test;

/**
 * @author EgorBusuioc
 * 17.04.2024
 */
public class ChooseBikeTypeServiceTest {
    @Test
    public void getFormatCategory() {
        String str = "S_WORKS_BIKE";
        int countUnderlineSymbols = (int) str.chars().filter(ch -> ch == '_').count();
        StringBuilder stringBuilder = new StringBuilder();
        int tempIndex = 0;
        int index;
        for (int i = 0; i < countUnderlineSymbols; i++) {
            index = str.indexOf("_", tempIndex);
            if(i + 1 == countUnderlineSymbols) {
                stringBuilder.append(str.charAt(tempIndex))
                        .append(str.substring(tempIndex + 1, index).toLowerCase())
                        .append(" ");
                tempIndex = index + 1;
                stringBuilder.append(str.charAt(tempIndex))
                        .append(str.substring(tempIndex + 1).toLowerCase());
            }
            else
                stringBuilder.append(str.charAt(tempIndex))
                        .append(str.substring(tempIndex + 1, index).toLowerCase())
                        .append("-");
            tempIndex = index + 1;
        }
        System.out.println(stringBuilder);
    }
}
