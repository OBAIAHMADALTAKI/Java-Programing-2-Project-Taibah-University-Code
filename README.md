# Java Programming 2 – Taibah University Project

![Java](https://img.shields.io/badge/Language-Java-orange?logo=java) ![Platform](https://img.shields.io/badge/Platform-NetBeans-blue) ![University](https://img.shields.io/badge/University-Taibah-green)

A Java console application developed as a course project for **Java Programming 2** at **Taibah University**. The project demonstrates core Java concepts including custom data structures, file I/O, string manipulation, and statistical computation.

---

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Sample Output](#sample-output)
- [Getting Started](#getting-started)
- [Requirements](#requirements)
- [Author](#author)

---

## Overview

This project implements a dynamic list (similar to an `ArrayList`) built from scratch using Java, along with utilities for:

- **String/list manipulation** — adding, updating, and managing elements.
- **Statistical analysis** — computing the maximum, minimum, sum, average, size, and capacity of the list.
- **Date/time reporting** — writing detailed calendar information to a text file using Java's `Calendar` API.
- **File I/O** — reading from and writing results to `.txt` files.

---

## Features

- Custom generic-style list management (`stringupdatepackage`)
- Compute statistics: **Max**, **Min**, **Sum**, **Average**, **Size**, **Capacity**
- Write full date/time breakdown (year, month, day, week, hour, minute, second, millisecond, AM/PM) to a file
- Read and display stored statistics from a file
- Built and run using **Apache NetBeans** (Ant-based build system)

---

## Project Structure

```
Java-Programing-2-Project-Taibah-University-Code/
│
├── src/
│   └── stringupdatepackage/      # Main Java source files
│
├── nbproject/                    # NetBeans project configuration
│
├── ReadTheStatistic.txt          # Output: computed statistics from the list
├── WriteTheDate.txt              # Output: detailed date/time information
│
├── build.xml                     # Apache Ant build file
├── manifest.mf                   # JAR manifest
└── .gitignore
```

---

## Sample Output

**`ReadTheStatistic.txt`** — statistics computed from the list `[10.0, 1.0, 5.0, 7.0, 1000.0]`:

```
List: [10.0, 1.0, 5.0, 7.0, 1000.0]
Max: 1000.0
Min: 1.0
Size: 5
Capacity: 5
Sum: 1023.0
Average: 204.6
```

**`WriteTheDate.txt`** — date/time snapshot written by the program:

```
Fri May 09 23:23:16 GMT+03:00 2025
YEAR: 2025
MONTH: 4
NameOfMONTH: May
DAY_OF_MONTH: 9
DAY_OF_WEEK: 6
NameOfDay: Friday
DAY_OF_WEEK_IN_MONTH: 2
DAY_OF_YEAR: 129
WEEK_OF_MONTH: 2
WEEK_OF_YEAR: 19
HOUR: 11
HOUR_OF_DAY: 23
MINUTE: 23
SECOND: 20
MILLISECOND: 726
AM_PM: PM
```

---

## Getting Started

### Clone the repository

```bash
git clone https://github.com/obaicodes/Java-Programing-2-Project-Taibah-University-Code.git
cd Java-Programing-2-Project-Taibah-University-Code
```

### Run with NetBeans

1. Open **Apache NetBeans**.
2. Go to **File → Open Project** and select the cloned folder.
3. Click **Run Project** (F6) to build and execute.

### Run with Ant (command line)

```bash
ant run
```

> Make sure Apache Ant and a JDK (Java 8 or later) are installed and available in your `PATH`.

---

## Requirements

| Tool | Version |
|------|---------|
| Java JDK | 8 or later |
| Apache NetBeans | Any recent version |
| Apache Ant | 1.9+ (bundled with NetBeans) |

---

## Author

**Obai Ahmad Al-Taki**  
Student — Java Programming 2  
Taibah University

---

*This project was submitted as part of the Java Programming 2 course curriculum at Taibah University.*
