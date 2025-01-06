```markdown
# File Character Statistics

## Project Overview
This Java program processes a text file to compute and display statistics about the frequency of ASCII characters. 
The program skips non-ASCII characters and whitespaces, informing the user about skipped non-ASCII characters. 
It provides two sorted views of the statistics: by character and by frequency (descending). This is a useful utility 
for analyzing text data.

## Features
- Reads characters from a text file named `input.txt`.
- Counts occurrences of ASCII characters (0–127).
- Ignores non-ASCII characters and prints a message for each skipped character.
- Excludes whitespaces from the statistics.
- Handles empty files gracefully, notifying the user and exiting without errors.
- Reports file-related errors with user-friendly messages.
- Displays character statistics sorted:
  1. By ASCII order.
  2. By frequency (in descending order).

## How It Works
1. **Input File**: The program expects an input file (`input.txt`) in its working directory `file-characters-statistics`, 
   delete or replace the sample one. The file should contain text data.
2. **Processing**:
   - Reads the file character by character.
   - Counts ASCII characters while ignoring whitespaces and skipping non-ASCII characters.
   - Maintains a frequency table for ASCII characters.
3. **Output**:
   - Displays statistics sorted by ASCII order.
   - Displays statistics sorted by frequency (descending).

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher.
- A text file named `input.txt` with content to analyze.

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/Kiriweb/file-characters-statistics.git
   ```
2. Navigate to the project directory:
   ```bash
   cd file-characters-statistics\gr\kiriweb\filecharacters
   ```
3. Compile the Java program:
   ```bash
   javac FileCharacterStatistics.java
   ```

### Running the Program
1. Place the `input.txt` file in the root project directory `file-characters-statistics`, delete or replace the sample one.
2. Navigate to the program directory:
   ```bash
   cd gr\kiriweb\filecharacters
   ```
3. Run the program:
   ```bash
   java FileCharacterStatistics
   ```

## Example

### Input File (`input.txt`):
```
Hello, World!
123
ΩΘΓ
```

### Console Output:
```
Character: Ω is not ASCII so it is skipped.
Character: Θ is not ASCII so it is skipped.
Character: Γ is not ASCII so it is skipped.

Statistics Sorted by Character:
Character: !, Count: 1
Character: ,, Count: 1
Character: 1, Count: 1
Character: 2, Count: 1
Character: 3, Count: 1
Character: H, Count: 1
Character: W, Count: 1
Character: d, Count: 1
Character: e, Count: 1
Character: l, Count: 3
Character: o, Count: 2
Character: r, Count: 1

Statistics Sorted by Frequency:
Character: l, Count: 3
Character: o, Count: 2
Character: !, Count: 1
Character: ,, Count: 1
Character: 1, Count: 1
Character: 2, Count: 1
Character: 3, Count: 1
Character: H, Count: 1
Character: W, Count: 1
Character: d, Count: 1
Character: e, Count: 1
Character: r, Count: 1
```

## Project Structure
```
file-characters-statistics\gr\kiriweb\filecharacters
├── FileCharacterStatistics.java  # Main program file
└── README.md                     # Project documentation
```
```
file-characters-statistics\
├── input.txt                     # Input text file
```

## Notes
- Non-ASCII characters are ignored, but each occurrence is logged in the console.
- Empty files are handled gracefully with a message indicating no data.

## Author
[Kyriakos Koutsourelis](https://github.com/Kiriweb)
```