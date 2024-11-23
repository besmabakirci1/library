package main;

public class ISBNGenerator {
    private static int publisherCounter = 0; // Yayıncı sayaç
    private static int bookCounter = 1; // Kitap sayaç

    public static String generateISBN(String publisher) {
        String prefix = "978"; // ISBN prefixi
        String group = "605"; // Türkçe yayınlar için grup kodu

        // Yayıncıya özel kod üretimi
        String publisherCode = String.format("%03d", ++publisherCounter);

        // Kitaba özel kod
        String titleCode = String.format("%04d", bookCounter++);

        // İlk 12 basamak
        String isbnWithoutCheckDigit = prefix + group + publisherCode + titleCode;

        // Check Digit hesaplama
        int checkDigit = calculateCheckDigit(isbnWithoutCheckDigit);

        // ISBN oluşturma
        return isbnWithoutCheckDigit + checkDigit;
    }

    private static int calculateCheckDigit(String isbnWithoutCheckDigit) {
        int sum = 0;
        for (int i = 0; i < isbnWithoutCheckDigit.length(); i++) {
            int digit = Character.getNumericValue(isbnWithoutCheckDigit.charAt(i));
            sum += (i % 2 == 0) ? digit : digit * 3; // Tek ve çift basamak çarpanı
        }
        int remainder = sum % 10;
        return (remainder == 0) ? 0 : 10 - remainder;
    }
}

