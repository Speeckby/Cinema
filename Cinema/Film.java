package Cinema;

import java.util.Comparator;

public class Film {
	protected String title;
	protected String year;
	protected String date_published;
	protected String genre;
	protected String duration;
	protected String country;
	protected String language;
	protected String director;
	protected String writer;
	protected String actors;
	protected String description;
	protected String avg_vote;
	protected String votes;
	protected float note;
	public Film(String title, String year, String date_published, String genre, String duration, String country,
			String language, String director, String writer, String actors, String description, String avg_vote,
			String votes) {
		this.title = title;
		this.year = year;
		this.date_published = date_published;
		this.genre = genre;
		this.duration = duration;
		this.country = country;
		this.language = language;
		this.director = director;
		this.writer = writer;
		this.actors = actors;
		this.description = description;
		this.avg_vote = avg_vote;
		this.votes = votes;
		if (!title.equals("Titre")) {
			note = Float.parseFloat(avg_vote);
		}
	}

	public String toString() {
		String[] temp = { title, description, country, language, writer, actors };
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].length() > 45) {
				temp[i] = temp[i].substring(0, 45).concat("[...]");
			}
		}
		return String.format("%-60s%-10s%-20s%-60s%-40s%-10s%-60s%-60s%-60s%-60s%-60s%-20s", temp[0], year,
				date_published, temp[1], genre, duration, temp[2], temp[3], director, temp[4], temp[5], avg_vote,
				votes);
	}

	static public Comparator<Film> compareTitle = new Comparator<Film>() {

		public int compare(Film jv1, Film jv2) {
			return jv1.title.compareToIgnoreCase(jv2.title);
		}
	};
	static public Comparator<Film> reverseCompareTitle = new Comparator<Film>() {

		public int compare(Film jv1, Film jv2) {
			return -jv1.title.compareToIgnoreCase(jv2.title);
		}
	};
	static public Comparator<Film> compareAnnee = new Comparator<Film>() {

		public int compare(Film jv1, Film jv2) {
			return Integer.parseInt(jv1.year) - Integer.parseInt(jv2.year);
		}
	};
	static public Comparator<Film> reverseCompareAnnee = new Comparator<Film>() {

		public int compare(Film jv1, Film jv2) {
			return -(Integer.parseInt(jv1.year) - Integer.parseInt(jv2.year));
		}
	};
	static public Comparator<Film> comparePays = new Comparator<Film>() {

		public int compare(Film jv1, Film jv2) {
			return jv1.country.compareToIgnoreCase(jv2.country);
		}
	};
	static public Comparator<Film> reverseComparePays = new Comparator<Film>() {

		public int compare(Film jv1, Film jv2) {
			return -jv1.country.compareToIgnoreCase(jv2.country);
		}
	};
	static public Comparator<Film> compareNote = new Comparator<Film>() {

		public int compare(Film jv1, Film jv2) {
			return jv1.avg_vote.compareToIgnoreCase(jv2.avg_vote);
		}
	};
	static public Comparator<Film> reverseCompareNote = new Comparator<Film>() {

		public int compare(Film jv1, Film jv2) {
			return -jv1.avg_vote.compareToIgnoreCase(jv2.avg_vote);
		}
	};
}
