package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.jdbc.PgArray;

import com.revature.exceptions.MediaNotFoundException;
import com.revature.launcher.Entertainment720Launcher;
import com.revature.models.EntertainmentMedia;
import com.revature.models.Movie;
import com.revature.util.ConnectionFactory;

public class EntertainmentMediaPostgresDao implements EntertainmentMediaDAO {

	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();

	
	public EntertainmentMedia saveOne(EntertainmentMedia em) {
		// assume only movies
		Connection conn = cf.getConnection();
		try {
			conn.setAutoCommit(false);

			String mediaSQL = "insert into \"media\" "
					+ "(\"price\", \"type\", \"name\", \"copyright_owner\", \"release_date\", \"rating\", \"max_age\" , \"min_age\") "
					+ "values (?, ?, ?, ?, ?, ?, ? ,? ) returning \"media_id\";";
			// prepared statement allows for provided params
			// very important that you use a prepared statement instead of a regular
			// statement if dealing with user input of any kind
			// if we just add user input in a a string or value, we run the risk of sql
			// injection
			PreparedStatement insertMedia = conn.prepareStatement(mediaSQL);

			insertMedia.setDouble(1, em.getPrice());
			insertMedia.setString(2, em.getType());
			insertMedia.setString(3, em.getName());
			insertMedia.setString(4, em.getCopyrightOwner());
			insertMedia.setTimestamp(5, Timestamp.valueOf(em.getReleaseDate()));
			insertMedia.setInt(6, em.getRating());
			insertMedia.setInt(7, em.getRecommendedAgeRange()[1]);
			insertMedia.setInt(8, em.getRecommendedAgeRange()[0]);

			ResultSet res = insertMedia.executeQuery();
			int newId;
			if (res.next()) {
				newId = res.getInt("media_id");
			} else {
				throw new SQLException();
			}
			em.setMediaId(newId);
			if (em.getClass() == Movie.class) {
				Movie m = (Movie) em;
				String movieSql = "insert into movie (\"runtime\", \"main_media\")" + "values( ?,  ?);";
				PreparedStatement insertMovie = conn.prepareStatement(movieSql);
				insertMovie.setDouble(1, m.getRuntime());
				insertMovie.setInt(2, newId);

				insertMovie.executeQuery();

				// TODO
//				PreparedStatement insertCrew = conn.prepareStatement(sql);
//				PreparedStatement insertMovieCrew = conn.prepareStatement(sql);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.commit();
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cf.releaseConnection(conn);
		}

		// return the original object but with any database generated fields filled out
		return em;
	}


	public EntertainmentMedia updateEntertainmentMedia(EntertainmentMedia em) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<EntertainmentMedia> findAll() {
		Connection conn = this.cf.getConnection();
		List<EntertainmentMedia> all = new ArrayList<EntertainmentMedia>();

		try {
			String sql = "select * from all_movies;";// we know this is a view for a gross sql query
			// we only use statements for very basic sql queries
			Statement s = conn.createStatement();

			ResultSet res = s.executeQuery(sql);

			while (res.next()) {
				// make a new movie
				Movie m = new Movie();
				m.setName(res.getString("name"));
				m.setCopyrightOwner(res.getString("copyright_owner"));
				m.setCredits((String[]) ((PgArray) res.getObject("credits")).getArray());// test this
				m.setPrice(res.getDouble("price"));
				m.setRating(res.getInt("rating"));
				m.setRecommendedAgeRange(new int[] { res.getInt("min_age"), res.getInt("max_age") });
				m.setReleaseDate(res.getString("release_date"));
				m.setRuntime(res.getDouble("runtime"));
				all.add(m);
			}
			// TODO
			// repeat for finding books as well

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// if we actually had a pool of connections, we would do this
			cf.releaseConnection(conn);
		}
		Entertainment720Launcher.e720Logger.info(all);
		return all;
	}


	public EntertainmentMedia findEntertainmentMediaByName(String name) throws MediaNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
