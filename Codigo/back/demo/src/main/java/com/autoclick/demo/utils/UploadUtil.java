package com.autoclick.demo.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.springframework.web.multipart.MultipartFile;

public class UploadUtil {

    public static boolean fazerUploadImagem(MultipartFile imagem) {
        boolean sucessoUpload = false;

        if (!imagem.isEmpty()) {
            String nomeArquivo = imagem.getOriginalFilename();

            try {
                // Código para obter o diretório dinamicamente (deixado comentado):
                // String baseDir = System.getProperty("user.dir");
                // String relativePath = "Codigo"
                // + File.separator + "front"
                // + File.separator + "autoclick"
                // + File.separator + "public"
                // + File.separator + "img-uploads";
                // String pastaUploadImagens = baseDir + File.separator + relativePath;

                // Caminho fixo conforme solicitado:
                String pastaUploadImagens = "C:\\Users\\ticok\\OneDrive\\Documentos\\GitHub\\pmg-es-2025-1-ti3-9577100-autoclick\\Codigo\\front\\autoclick\\public\\img-uploads";

                // String pastaUploadImagens =
                // "C:\\Users\\Christiane\\TI3\\pmg-es-2025-1-ti3-9577100-autoclick\\Codigo\\front\\autoclick\\public\\img-uploads";
                // String pastaUploadImagens =
                // "C:\\Users\\ticok\\OneDrive\\Documentos\\GitHub\\pmg-es-2025-1-ti3-9577100-autoclick\\Codigo\\front\\autoclick\\public\\img-uploads";
                // String pastaUploadImagens =
                // "C:\\Users\\ticok\\OneDrive\\Documentos\\GitHub\\pmg-es-2025-1-ti3-9577100-autoclick\\Codigo\\front\\autoclick\\public\\img-uploads";
                // String pastaUploadImagens =
                // "C:\\Users\\ticok\\OneDrive\\Documentos\\GitHub\\pmg-es-2025-1-ti3-9577100-autoclick\\Codigo\\front\\autoclick\\public\\img-uploads";

                File dir = new File(pastaUploadImagens);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                // Criando o arquivo no diretório
                File serverFile = new File(dir.getAbsolutePath() + File.separator + nomeArquivo);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(imagem.getBytes());
                stream.close();

                System.out.println("Arquivo salvo em: " + serverFile.getAbsolutePath());
                System.out.println("Você fez o upload do arquivo: " + nomeArquivo + " com sucesso!");
                sucessoUpload = true;
            } catch (Exception e) {
                System.out.println("Erro ao fazer upload do arquivo: " + nomeArquivo + " -> " + e.getMessage());
            }
        } else {
            System.out.println("Arquivo vazio!");
        }

        return sucessoUpload;
    }
}
