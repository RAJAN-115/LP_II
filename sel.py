def selection_sort(arr):
    sorted_arr = []
    
    while arr:
        min_num = min(arr)  # Find the minimum element in the remaining unsorted array
        sorted_arr.append(min_num)  # Add the minimum element to the sorted array
        arr.remove(min_num)  # Remove the minimum element from the unsorted array
    
    return sorted_arr

# Example usage
user_input = input("Enter a list of numbers separated by spaces: ")
numbers = [int(num) for num in user_input.split()]

sorted_numbers = selection_sort(numbers)
print("Sorted numbers:", sorted_numbers)
