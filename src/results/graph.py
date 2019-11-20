import pandas as pd
import matplotlib.pyplot as plt

# Opens the CSV File.
df1 = pd.read_csv("Selection Sort.csv")
df2 = pd.read_csv("Merge Sort.csv")

# Creates a graph comparing Elapsed Time of sorting Sorted arrays between Selection Sort and Merge Sort.
plt.figure(1)
plt.title("Sorting Sorted Array")
plt.plot(df1["Sorted Array Elapsed Time"])
plt.plot(df2["Sorted Array Elapsed Time"])
plt.xlabel("Length of Sorted Array")
plt.ylabel("Average Elapsed Time (nano seconds)")
plt.legend(["Selection Sort", "Merge Sort"])

# Creates a graph comparing Elapsed Time of sorting Randomly Generated arrays between Selection Sort and Merge Sort.
plt.figure(2)
plt.title("Sorting Randomly Generated Array")
plt.plot(df1["Randomised Array Elapsed Time"])
plt.plot(df2["Randomised Array Elapsed Time"])
plt.xlabel("Length of Randomised Array")
plt.ylabel("Average Elapsed Time (nano seconds)")
plt.legend(["Selection Sort", "Merge Sort"])

# Creates a graph comparing Elapsed Time of sorting Anti Sorted arrays between Selection Sort and Merge Sort.
plt.figure(3)
plt.title("Sorting Anti-Sorted Generated Array")
plt.plot(df1["Anti-Sorted Array Elapsed Time"])
plt.plot(df2["Anti-Sorted Array Elapsed Time"])
plt.xlabel("Length of Anti-Sorted Array")
plt.ylabel("Average Elapsed Time (nano seconds)")
plt.legend(["Selection Sort", "Merge Sort"])

# Creates a graph comparing Elapsed Time of sorting different types of arrays using Selection Sort.
plt.figure(4)
plt.title("Selection Sort")
plt.plot(df1["Sorted Array Elapsed Time"])
plt.plot(df1["Randomised Array Elapsed Time"])
plt.plot(df1["Anti-Sorted Array Elapsed Time"])
plt.xlabel("Length of Array")
plt.ylabel("Average Elapsed Time (nano seconds)")
plt.legend(["Sorted Array", "Randomised Array", "Anti-Sorted Array"])

# Creates a graph comparing Elapsed Time of sorting different types of arrays using Merge Sort.
plt.figure(5)
plt.title("Merge Sort")
plt.plot(df2["Sorted Array Elapsed Time"])
plt.plot(df2["Randomised Array Elapsed Time"])
plt.plot(df2["Anti-Sorted Array Elapsed Time"])
plt.xlabel("Length of Array")
plt.ylabel("Average Elapsed Time (nano seconds)")
plt.legend(["Sorted Array", "Randomised Array", "Anti-Sorted Array"])

plt.show()
