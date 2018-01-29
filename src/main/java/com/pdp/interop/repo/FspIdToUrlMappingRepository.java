package com.pdp.interop.repo;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.Json;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.apache.commons.lang.CharEncoding.UTF_8;

public class FspIdToUrlMappingRepository {

    private static final Logger log = LoggerFactory.getLogger(FspIdToUrlMappingRepository.class);

    private String fileLocation;

    public FspIdToUrlMappingRepository() {
        this.fileLocation = System.getProperty("user.home") + "/fsp_id_to_url_db.csv";
    }

    public void addIdBaseUrlMapping(String fspId, String fspUrl) throws IOException {
        Files.write(Paths.get(fileLocation), (fspId + ";" + fspUrl + System.lineSeparator()).getBytes(UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

    }

    public String getBaseUrlById(String fspId) throws IOException {
        log.info("Input FspId: "+fspId);
        try {
            return Files.lines(new File(fileLocation).toPath())
                    .map(line -> Arrays.asList(line.split(";")))
                    .filter(list -> list.get(0).equalsIgnoreCase(fspId))
                    .collect(Collectors.toList())
                    .get(0).get(1).replace(System.lineSeparator(), "");
        } catch(Exception e){
            log.error(ExceptionUtils.getFullStackTrace(e));
            throw e;
        }
    }
}
