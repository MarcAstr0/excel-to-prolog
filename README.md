excel-to-prolog
===============

CLI tool to convert MS Excel spreadsheets to Prolog knowledge bases.

Purpose
-------

The purpose of this tool is to write Prolog facts in Excel and be able to export them in `.pl` format.
For example, the following Excel sheet named `parent`:

![Screenshot](screenshot.png)

Will convert to `parent.pl` like this:

```prolog
parent(david, john).
parent(john, eliza).
parent(suzie, eliza).
```