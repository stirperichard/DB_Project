package com.afjcjsbx.mrg.util;


public class Query {


    public static final String FIND_REGISTERED_USER = "SELECT * FROM users WHERE username = ? and password = ?";

    public static final String FIND_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?";

    public static final String INSERT_CLUMP = "INSERT INTO clump (id, lat, lng, temp, den_sup, t_m) VALUES (?, ?, ?, ?, ?, ?)";

    public static final String INSERT_USER = "INSERT INTO users (username, password, email, nome, cognome, type) VALUES (?, ?, ?, ?, ?, 'U')";


    public static final String INSERT_SATELLITE = "INSERT INTO satellite (nome, operativo_da, agenzia, fine_operazione) VALUES (?, ?, ?, ?)";

    public static final String INSERT_STRUMENTO = "INSERT INTO strumenti (nome, satellite, mappa) VALUES (?, ?, ?)";


    public static final String INSERT_AGENZIA = "INSERT INTO agenzia (nome) VALUES (?)";

    public static final String GET_MAPPE = "SELECT * FROM mappa_stellare";

    public static final String GET_AGENZIE = "SELECT * FROM agenzia";

    public static final String GET_SATELLITI = "SELECT * FROM satellite";

    public static final String GET_MAPPE_STELLARI = "SELECT * FROM mappa_stellare";


    public static final String GET_OGGETTI_IN_MAPPA = "SELECT * FROM sorgenti, mappa_stellare WHERE sorgenti.mappa = mappa_stellare.nome AND mappa_stellare.nome = ?";

    public static final String GET_OGGETTI_IN_MAPPA_WITH_BANDA = "SELECT * FROM sorgenti, mappa_stellare WHERE sorgenti.mappa = mappa_stellare.nome AND mappa_stellare.nome = ?";

    public static final String SEARCH_CLUMP_BAND_FLUX_BY_ID = "SELECT * " +
            "FROM clump, sorgenti, flussi " +
            "JOIN banda b ON b.risoluzione = sorgenti.banda_r AND b.lunghezza_spettrale = sorgenti.banda_l " +
            "WHERE sorgenti.clump = clump.id AND flussi.sorgente = sorgenti.id AND clump.id = ?";


    public static final String COUNT_CLUMPS = "SELECT COUNT(*) AS number FROM clump";

    public static final String SEARCH_CLUMP_BY_ID = "SELECT * FROM clump WHERE clump.id = ?";

    public static final String SEARCH_CLUMPS_BY_DENSITY = "SELECT * FROM clump WHERE den_sup > 0.1 AND den_sup < 1.0";

    public static final String VIEW_MASSA_CLUMP = "CREATE OR REPLACE VIEW view_massa_clumps AS " +
            "SELECT clump.id, clump.temp, flussi.valore, COUNT(*) as numero_sorgenti" +
            "FROM clump, sorgente, flussi, banda" +
            "WHERE banda.flusso = flissi.id AND flussi.sorgente = sorgenti.id AND sorgenti.clump = clump.id" +
            "AND banda.risoluzione = '350'" +
            "GROUP BY clump.id, clump.temp, flussi.valore";


    public static final String MASSA_CLUMP = "SELECT clump.id, (numero_sorgenti*(0.053 * valore * 100) * ((EXP(41.14 / temp) - 1))) "+
            "AS massa_clump FROM view_massa_clumps;";


    public static final String STATISTICS = "SELECT AVG(massa_clump) as media, STDDEV(massa_clump) as deviazione_standard" +
            "SELECT MEDIAN(massa_clump) as mediana, MEDIAN(ABS(massa_clump - MEDIAN(massa_clump))) as mediana_media_assoluta" +
            "FROM view_massa_clumps";

    public static final String YOUNG_SOURCE = "SELECT *" +
            "FROM Clumps as c join MappaStellare as ms join (SELECT f1.Valore as Flusso1, f2.Valore as Flusso2, f3.Valore as Flusso3" +
            "FROM Banda as b1 join Banda as b2 join Banda as b3 join Flussi as f1 join Flussi as f2 join Flussi as f3" +
            "WHERE b1.Flussi = f1.Id and b2.Flussi = f2.Id and b3.Flussi = f3.Id and b1.Risoluzione = 3.6 and b2.Risoluzione = 4.5 and b3.Risoluzione = 5.4)" +
            "WHERE f1.clumps = c.Id and c.MappaStellare = ms.Nome and ms.Nome = 'MIPSGAL' and ((f2 - f3 > 0.7) OR (f1 - f2 > 0.7) OR (f1 - f2 > 1.4 * (f2 - f1 - 0.7) + 0.15))";
}


