package com.kunal.SpringBootCrud.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.kunal.SpringBootCrud.bean.Subject;


public class CSVWriterUtility {

	private static CellProcessor[] getProcessors() {

       final CellProcessor[] processors = new CellProcessor[]{
//                new UniqueHashCode(), // employee No (must be unique)
                new NotNull(), // Name
                new NotNull(), // role

                //can be used for date field
                // new FmtDate("dd/MM/yyyy"),

                //for optional fields
                //  new Optional(new FmtBool("Y", "N")),
                // new Optional(),

        };

        return processors;
    }


    public static void subjectDetailReport(HttpServletResponse response, List<Subject> subject) {

        try (ICsvBeanWriter beanWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE)) {

            final String[] header = new String[]{"Id", "Name"};

            final CellProcessor[] processors = getProcessors();

            //set Header
            beanWriter.writeHeader(header);

            //Set data
            for (Subject  sub : subject) {
                beanWriter.write(sub, header, processors);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
