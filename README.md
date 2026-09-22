# CSE 11, PA 0

`Pict.java` is the book's image library — the same `Circle`, `Beside`,
`ImageIO_` and the rest; the appendix lists everything. Leave it as it is and
write each program in a file of its own, like `Example.java`. Run one with:

```
java -ea Example.java
```

That writes `example.png` next to the program; there is no separate compile
step. `-ea` turns on `assert`. `ImageIO_.show` opens a window on your own
machine; in a Codespace there is no display, so it writes `shown-0.png`.

Java 25 is required (`void main()` with no class around it). The
`.devcontainer` here gets you that in GitHub Codespaces.
