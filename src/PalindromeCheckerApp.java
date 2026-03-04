import java.util.Stack;

/**
 * ======================================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ======================================================================
 * * Use Case 12: Strategy Pattern for Palindrome Algorithms
 * * Description:
 * This class demonstrates how different palindrome
 * validation algorithms can be selected dynamically
 * at runtime using the Strategy Design Pattern.
 * * At this stage, the application:
 * - Defines a common PalindromeStrategy interface
 * - Implements a concrete Stack based strategy
 * - Injects the strategy at runtime
 * - Executes the selected algorithm
 * * The goal is to teach extensible algorithm design.
 * * @author Developer
 * @version 12.0
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "level";

        // Step 1: Create a concrete strategy (Stack-based)
        PalindromeStrategy strategy = new StackStrategy();

        // Step 2: Inject and execute the strategy (Polymorphism)
        boolean isPalindrome = strategy.check(input);

        // Console Output
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}

/**
 * ======================================================================
 * INTERFACE - PalindromeStrategy
 * ======================================================================
 * This interface defines a contract for all
 * palindrome checking algorithms.
 */
interface PalindromeStrategy {
    /**
     * Any new algorithm must implement this interface
     * and provide its own validation logic.
     */
    boolean check(String input);
}

/**
 * ======================================================================
 * CLASS - StackStrategy
 * ======================================================================
 * This class provides a Stack based implementation
 * of the PalindromeStrategy interface.
 * It uses LIFO behavior to reverse characters.
 */
class StackStrategy implements PalindromeStrategy {

    /**
     * Implements palindrome validation using Stack.
     * @param input String to validate
     * @return true if palindrome, false otherwise
     */
    @Override
    public boolean check(String input) {
        // Create a stack to store characters
        Stack<Character> stack = new Stack<>();

        // Push each character onto the stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Compare characters by popping from the stack
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}