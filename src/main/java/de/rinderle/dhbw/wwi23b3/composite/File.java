package de.rinderle.dhbw.wwi23b3.composite;

class File implements FileSystemComponent {
    private String name;
    private long size; // File size in KB

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String showDetails() {
        return "File: " + name + " (" + size + "KB)";
    }
}