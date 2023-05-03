package edu.lernia.labb4;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class TollFeeTest {
    @Test
    @DisplayName("Check TotalFeeCost")
    void testTotalFeeCost() {
        LocalDateTime[] date1 = new LocalDateTime[5];
        date1[0] = LocalDateTime.of(2020,Month.JUNE, 30, 6, 30);
        date1[1] = LocalDateTime.of(2020,Month.JUNE, 30, 8, 10);
        date1[2] = LocalDateTime.of(2020,Month.JUNE, 30, 15, 30);
        date1[3] = LocalDateTime.of(2020,Month.JUNE, 30, 17, 20);
        date1[4] = LocalDateTime.of(2020,Month.JUNE, 30, 18, 29);
        assertEquals(60, TollFeeCalculator.getTotalFeeCost(date1));
    }
    @Test
    @DisplayName("Check one")
    void testTollFeeOnePassing() {
        LocalDateTime date;
        date = LocalDateTime.of(2020,Month.JUNE, 30, 15, 29);
        assertEquals(13, TollFeeCalculator.getTollFeePerPassing(date));
    }
    @Test
    @DisplayName("Check if dates is toll free")
    void testTollFreeDate() {
        LocalDateTime[] date = new LocalDateTime[3];

        date [0]= LocalDateTime.of(2020,Month.JUNE, 27, 15, 30);
        date [1]= LocalDateTime.of(2020,Month.JUNE, 28, 15, 30);
        date [2]= LocalDateTime.of(2020,Month.JULY, 27, 15, 30);

        assertTrue(TollFeeCalculator.isTollFreeDate(date[0]));
        assertTrue(TollFeeCalculator.isTollFreeDate(date[1]));
        assertTrue(TollFeeCalculator.isTollFreeDate(date[2]));
    }
    @Test
    @DisplayName("Testing six passes att same hour")
    void testSameHour() {
        LocalDateTime[] date = new LocalDateTime[6];
        date[0] = LocalDateTime.of(2020, Month.JUNE, 30, 15, 20);
        date[1] = LocalDateTime.of(2020, Month.JUNE, 30, 15, 37);
        date[2] = LocalDateTime.of(2020, Month.JUNE, 30, 15, 48);
        date[3] = LocalDateTime.of(2020, Month.JUNE, 30, 16, 10);
        date[4] = LocalDateTime.of(2020, Month.JUNE, 30, 16, 14);
        date[5] = LocalDateTime.of(2020, Month.JUNE, 30, 16, 19);
        assertEquals(18, TollFeeCalculator.getTotalFeeCost(date));
    }
    @Test
    @DisplayName("Testing four passages with different hours")
    void testFourPassFee() {
        LocalDateTime[] date = new LocalDateTime[4];
        date[0] = LocalDateTime.of(2020, Month.JUNE, 30, 10, 10);
        date[1] = LocalDateTime.of(2020, Month.JUNE, 30, 12, 30);
        date[2] = LocalDateTime.of(2020, Month.JUNE, 30, 14, 15);
        date[3] = LocalDateTime.of(2020, Month.JUNE, 30, 15, 45);

        assertEquals(42, TollFeeCalculator.getTotalFeeCost(date));
    }

}