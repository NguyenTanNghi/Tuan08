package iuh.fit.edu.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Service
public class FileStorageService {

    private final Path root;

    public FileStorageService(@Value("${app.upload.dir}") String uploadDir) throws IOException {
        this.root = Paths.get(uploadDir).toAbsolutePath().normalize();
        Files.createDirectories(this.root);
    }

    public String saveImage(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) return null;

        // Chỉ cho phép png, jpg, jpeg
        String original = file.getOriginalFilename();
        String lower = original == null ? "" : original.toLowerCase();
        if (!(lower.endsWith(".png") || lower.endsWith(".jpg") || lower.endsWith(".jpeg"))) {
            throw new IOException("Chỉ chấp nhận PNG/JPG/JPEG");
        }

        String ext = lower.substring(lower.lastIndexOf('.'));
        String filename = UUID.randomUUID() + ext;
        Path dest = this.root.resolve(filename);
        Files.copy(file.getInputStream(), dest, StandardCopyOption.REPLACE_EXISTING);
        return filename;
    }

    public void deleteIfExists(String filename) {
        if (filename == null || filename.isBlank()) return;
        try {
            Files.deleteIfExists(this.root.resolve(filename));
        } catch (IOException ignored) {}
    }
}
