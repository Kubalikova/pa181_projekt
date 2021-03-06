package cz.pa181.project.dao.zdravie;

import com.j256.ormlite.dao.Dao;
import cz.pa181.project.entity.zdravie.ZdraviePocetNemocnic;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public interface ZdraviePocetNemocnicDao extends Dao<ZdraviePocetNemocnic,Long> {

    /**
     *
     * @param rok rok (hodnoty od 1996 - 2017) hodnoty rovne ako zadany rok
     * @return zoradeny list casti bratislavy podla poctu nemocnic od najviac po najmenej
     * @throws SQLException e
     */
    List<String[]> getPocetNemocnicByRokSorted(int rok) throws SQLException;
}
