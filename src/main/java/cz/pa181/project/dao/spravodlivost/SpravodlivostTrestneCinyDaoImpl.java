package cz.pa181.project.dao.spravodlivost;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import cz.pa181.project.entity.spravodlivost.SpravodlivostTrestneCiny;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public class SpravodlivostTrestneCinyDaoImpl extends BaseDaoImpl<SpravodlivostTrestneCiny, Long> implements SpravodlivostTrestneCinyDao {
    public SpravodlivostTrestneCinyDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, SpravodlivostTrestneCiny.class);
    }

    @Override
    public List<String[]> getPocetZistenychTrestnychCinovByRokSorted(int rok) throws SQLException {
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM (pocetZistenych) as pocetZistenychs")
                .groupBy("okres")
                .orderByRaw("pocetZistenychs")
                .where().like("rok","%" + rok + "%")
                .queryRaw().getResults();
    }
}