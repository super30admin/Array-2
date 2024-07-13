#I decided to use a straightforward method to find both the minimum and maximum numbers in the list. My solution starts by assuming the first number in the list is both the minimum and maximum. Then, I go through each remaining number in the list one by one. For each number, I compare it to the current minimum and maximum. If it's smaller than the current minimum, I update the minimum. If it's larger than the current maximum, I update the maximum. This way, by the time I've looked at every number in the list, I've found the smallest and largest numbers. It's a simple approach that works for any list of numbers, including empty lists or lists with just one number.

def find_min_max(numbers):
    if not numbers:  # If the list is empty
        return None, None
    
    min_num = max_num = numbers[0]  # Start with the first number
    
    for num in numbers[1:]:  # Check each number from the second one
        if num < min_num:
            min_num = num  # Update min if we find a smaller number
        elif num > max_num:
            max_num = num  # Update max if we find a larger number
    
    return min_num, max_num