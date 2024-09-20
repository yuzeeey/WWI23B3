package de.rinderle.dhbw.wwi23b3.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileSystemTest {

    private Directory rootDir;
    private Directory documentsDir;
    private Directory picturesDir;
    private File file1;
    private File file2;
    private File file3;

    // Setting up the file system structure before each test
    @BeforeEach
    void setUp() {
        file1 = new File("File1.txt", 50);
        file2 = new File("File2.txt", 150);
        file3 = new File("File3.jpg", 200);

        documentsDir = new Directory("Documents");
        picturesDir = new Directory("Pictures");

        documentsDir.addComponent(file1);
        documentsDir.addComponent(file2);

        picturesDir.addComponent(file3);

        rootDir = new Directory("Root");
        rootDir.addComponent(documentsDir);
        rootDir.addComponent(picturesDir);
    }

    @Test
    void testFileDetails() {
        // Test that file1 shows the correct details
        String result = file1.showDetails();
        assertEquals("File: File1.txt (50KB)", result);
    }

    @Test
    void testDirectoryWithFilesDetails() {
        // Test that the directory shows the correct details for files
        String result = documentsDir.showDetails();
        String expected = """
                Directory: Documents
                File: File1.txt (50KB)
                File: File2.txt (150KB)
                """.trim();
        assertEquals(expected, result);
    }

    @Test
    void testRootDirectoryDetails() {
        // Test that the root directory shows the correct details, including subdirectories
        String result = rootDir.showDetails();
        String expected = """
                Directory: Root
                Directory: Documents
                File: File1.txt (50KB)
                File: File2.txt (150KB)
                Directory: Pictures
                File: File3.jpg (200KB)
                """.trim();
        assertEquals(expected, result);
    }

    @Test
    void testAddingComponent() {
        // Test adding a new file to the root directory
        File newFile = new File("NewFile.pdf", 300);
        rootDir.addComponent(newFile);

        String result = rootDir.showDetails();
        assertTrue(result.contains("File: NewFile.pdf (300KB)"));
    }

    @Test
    void testRemovingComponent() {
        // Test removing the Pictures directory from the root directory
        rootDir.removeComponent(picturesDir);

        String result = rootDir.showDetails();
        assertTrue(result.contains("Directory: Documents"));
        assertTrue(!result.contains("Directory: Pictures"));
    }
}
