class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int card : hand){
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        Arrays.sort(hand);
        for(int cards : hand){
            if(map.containsKey(cards)){
                for (int x = cards; x < cards + groupSize; ++x){
                    if (!map.containsKey(x)) {
                        return false;
                    }
                    map.put(x, map.get(x) - 1);
                    if (map.get(x) == 0) {
                        map.remove(x);
                    }
                }
            }
        }
        return true;
    }
}


public class CardGroups {
    public static boolean canRearrangeCards(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false; // If the total number of cards isn't divisible by groupSize, it's not possible
        }
        
        TreeMap<Integer, Integer> cardCount = new TreeMap<>();
        
        // Count each card
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }
        
        // Try to form groups
        while (!cardCount.isEmpty()) {
            int firstCard = cardCount.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int currentCard = firstCard + i;
                if (!cardCount.containsKey(currentCard)) {
                    return false;
                }
                int count = cardCount.get(currentCard);
                if (count == 1) {
                    cardCount.remove(currentCard);
                } else {
                    cardCount.put(currentCard, count - 1);
                }
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of cards:");
        int n = scanner.nextInt();
        
        int[] hand = new int[n];
        System.out.println("Enter the card values:");
        for (int i = 0; i < n; i++) {
            hand[i] = scanner.nextInt();
        }
        
        System.out.println("Enter the group size:");
        int groupSize = scanner.nextInt();
        
        boolean result = canRearrangeCards(hand, groupSize);
        System.out.println("Can the cards be rearranged into groups of " + groupSize + "? " + result);
    }
}