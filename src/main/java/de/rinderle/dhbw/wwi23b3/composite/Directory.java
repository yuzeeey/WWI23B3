package de.rinderle.dhbw.wwi23b3.composite;

import java.util.ArrayList;
import java.util.List;

// Composite
class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public String showDetails() {
        StringBuilder details = new StringBuilder("Directory: " + name + "\n");
        for (FileSystemComponent component : components) {
            details.append(component.showDetails()).append("\n");
        }
        return details.toString().trim();
    }
}