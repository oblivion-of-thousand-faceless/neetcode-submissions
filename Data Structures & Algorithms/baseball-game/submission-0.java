class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < operations.length; i++) {
            if (operations[i].equals("+")) {
                int first = stack.pop();
                int second = stack.peek();
                stack.push(first);
                stack.push(first + second);
            } else if (operations[i].equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (operations[i].equals("C")) {
                stack.pop();
            } else {
                int number = Integer.parseInt(operations[i]);
                stack.push(number);
            }

        }

        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}