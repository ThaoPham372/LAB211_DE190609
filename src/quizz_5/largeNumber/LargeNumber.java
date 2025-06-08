package quizz_5.largeNumber;

public class LargeNumber {
    private int[] digits;

    public LargeNumber(String number) {
        // Chuyển chuỗi sang mảng số nguyên
        digits = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            digits[i] = number.charAt(i) - '0';
        }
    }

    public String add(LargeNumber other) {
        int maxLength = Math.max(this.digits.length, other.digits.length);
        int[] result = new int[maxLength + 1];

        int carry = 0;
        int i = this.digits.length - 1;
        int j = other.digits.length - 1;
        int k = result.length - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? this.digits[i--] : 0;
            int digit2 = (j >= 0) ? other.digits[j--] : 0;

            int sum = digit1 + digit2 + carry;
            result[k--] = sum % 10;
            carry = sum / 10;
        }

        // Convert result to string (skip leading 0)
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (int digit : result) {
            if (digit == 0 && leadingZero) continue;
            leadingZero = false;
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public String multiply(LargeNumber other) {
        int[] result = new int[this.digits.length + other.digits.length];

        for (int i = this.digits.length - 1; i >= 0; i--) {
            for (int j = other.digits.length - 1; j >= 0; j--) {
                int mul = this.digits[i] * other.digits[j];
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + result[p2];

                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }

        // Convert result to string (skip leading 0)
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (int digit : result) {
            if (digit == 0 && leadingZero) continue;
            leadingZero = false;
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

