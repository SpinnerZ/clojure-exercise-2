# Clojure-exercise-2

It is a solution to "nuSwitch Energy Comparison" code challenge made in Clojure.

## Objectives

It helps to choose the best energy supplier company calculating by doing:

+ List plans prices on the market according to how much energy is consumed;
+ Calculates how much energy is used according to how much a customer spends each month on a specific plan

## Requisites

1. You will need a **Java Virtual Machine running**. I recommend install the [OpenJDK](https://openjdk.java.net/).
2. [Leinigen](https://leiningen.org/) is also needed.
3. A `json` file containing the plans. There is a [sample file](./resources/plans.json) with the expected structure in [resources folder](/resources).

## Usage

Execute the [comparison script](./bin/comparison) with the `json` file path. The script is located under the [bin folder](./bin). Example:

```bash
$ ./bin/comparison /path/to/plans.json
```

The program now will wait for input. There are three possible commands:

---

+ price ANNUAL_USAGE

For a given annual kWh consumption produces an annual inclusive of VAT price for all plans available on the market sorted by cheapest first and prints to stdout. Each plan will be printed on its own line in the format SUPPLIER,PLAN,TOTAL_COST. TOTAL_COST is printed in pounds and pence.

---

+ usage SUPPLIER_NAME PLAN_NAME SPEND

For the specified plan from a supplier calculates how much energy (in kWh) would be used annually from a monthly spend in pounds (inclusive of VAT) rounded to the nearest kWh and prints this value. SPEND is expected in pounds and pence.

---

+ exit

Leaves the program.

---

After **price** and **usage** results, the program will wait again for another input.

Example input command lines:

```bash
price 1000
price 1200
usage eon variable 40
usage edf fixed 59
exit
```

Output exaples for the example inputs, using the [sample `json` file](./resources/plans.json):

```
eon,variable,108.68
edf,fixed,111.25
ovo,standard,120.23
bg,standing-charge,121.33
edf,fixed,205.75
eon,variable,213.68
bg,standing-charge,215.83
ovo,standard,235.73
44267
103855
14954
```
