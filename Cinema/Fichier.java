package Cinema;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Fichier {
	private static List<Film> IMDbMovies = new LinkedList<Film>();
	private static Film exemple = new Film("Titre", "Année", "Date de parution", "Genre", "Durée", "Nationalité",
			"Langue", "Réalisateur", "Scénaristes", "Acteurs", "Description", "Note Moyenne", "Nombre de Notes");

	public static void main(String[] args) throws IOException {
		boolean fini = false;
		boolean choixValide, choixValide2, choixValide3;

		long startTime, endTime, duration;
		DecimalFormat df = new DecimalFormat("#.#######");
		int rep;
		System.out.println(" ██████╗██╗███╗   ██╗███████╗███╗   ███╗ █████╗ \r\n"
				+ "██╔════╝██║████╗  ██║██╔════╝████╗ ████║██╔══██╗\r\n"
				+ "██║     ██║██╔██╗ ██║█████╗  ██╔████╔██║███████║\r\n"
				+ "██║     ██║██║╚██╗██║██╔══╝  ██║╚██╔╝██║██╔══██║\r\n"
				+ "╚██████╗██║██║ ╚████║███████╗██║ ╚═╝ ██║██║  ██");
		System.out.println("");
		while (!fini) {
			System.out.println("₪═════════════════╣ 𝗤𝘂𝗲 𝘃𝗼𝘂𝗹𝗲𝘇 𝘃𝗼𝘂𝘀 𝗳𝗮𝗶𝗿𝗲 ? ╠══════════════════₪");
			System.out.println("1 - Charger les données (Pensez à vider la liste avant si nécessaire) ");
			System.out.println("2 - Afficher la liste");
			System.out.println("3 - Trier");
			System.out.println("4 - Filtrer");
			System.out.println("5 - Chercher");
			System.out.println("6 - Sauvegarder la liste");
			System.out.println("7 - Vider la liste");
			System.out.println("8 - Quitter");
			System.out.print("Votre choix (entier) : ");

			rep = Clavier.lireInt();
			System.out.println("");
			switch (rep) {
				case 1:
					int fichierChoix;
					choixValide = false;
					while (!choixValide) {
						System.out.println(
								"₪═════════════════╣ 𝗤𝘂𝗲𝗹 𝗳𝗶𝗰𝗵𝗶𝗲𝗿 𝘃𝗼𝘂𝗹𝗲𝘇-𝘃𝗼𝘂𝘀 𝗰𝗵𝗮𝗿𝗴𝗲𝗿 ? ╠══════════════════₪");
						System.out.println(String.format("%-25s%-20s", "1 - Base complète", "(80 944 films)"));
						System.out.println(String.format("%-25s%-20s", "2 - Base partielle", "(40 000 films)"));
						System.out.println(String.format("%-25s%-20s", "3 - Base partielle", "(10 000 films)"));
						System.out.println(String.format("%-25s%-20s", "4 - Base partielle", "(1 000 films)"));
						System.out.println(String.format("%-25s%-20s", "5 - Base partielle", "(100 films)"));
						System.out.println(String.format("6 - Annuler"));

						System.out.print("Votre choix (entier) : ");

						fichierChoix = Clavier.lireInt();
						if (fichierChoix >= 1 && fichierChoix <= 6) {
							choixValide = true;
							switch (fichierChoix) {
								case 1:
									startTime = System.nanoTime();
									ChargerFichier(80944);
									endTime = System.nanoTime();
									duration = endTime - startTime;
									System.out.println("");
									System.out.println("Le fichier IMDbmovieFULL a été chargé");
									System.out.println("temps : " + df.format(duration / 1000000.0) + "ms");
									break;
								case 2:
									startTime = System.nanoTime();
									ChargerFichier(40000);
									endTime = System.nanoTime();
									duration = endTime - startTime;
									System.out.println("");
									System.out.println("Le fichier IMDbmovieCUT40000 a été chargé");
									System.out.println("temps : " + df.format(duration / 1000000.0) + "ms");
									break;
								case 3:
									startTime = System.nanoTime();
									ChargerFichier(10000);
									endTime = System.nanoTime();
									duration = endTime - startTime;
									System.out.println("");
									System.out.println("Le fichier IMDbmovieCUT10000 a été chargé");
									System.out.println("temps : " + df.format(duration / 1000000.0) + "ms");
									break;
								case 4:

									startTime = System.nanoTime();
									ChargerFichier(1000);
									endTime = System.nanoTime();
									duration = endTime - startTime;
									System.out.println("");
									System.out.println("Le fichier IMDbmovieCUT1000 a été chargé");
									System.out.println("temps : " + df.format(duration / 1000000.0) + "ms");
									break;
								case 5:

									startTime = System.nanoTime();
									ChargerFichier(100);
									endTime = System.nanoTime();
									duration = endTime - startTime;
									System.out.println("temps : " + df.format(duration / 1000000.0) + "ms");
									System.out.println("");
									System.out.println("Le fichier IMDbmovieCUT100 a été chargé");
									break;
								case 6:
									break;
							}
						} else {
							System.out.println("");
							System.out.println("Choix incorrect, veuillez essayer à nouveau.");
							System.out.println("");
						}
					}
					break;
				case 2:
					startTime = System.nanoTime();
					AfficherValeurs();
					endTime = System.nanoTime();
					duration = endTime - startTime;
					System.out.println("temps : " + df.format(duration / 1000000.0) + "ms");
					break;
				case 3:
					// Trier
					int triChoix;
					int triSens;
					choixValide = false;
					choixValide2 = false;
					while (!choixValide) {
						System.out.println(
								"₪═════════════════╣ 𝗣𝗮𝗿 𝗾𝘂𝗼𝗶 𝘃𝗼𝘂𝗹𝗲𝘇 𝘃𝗼𝘂𝘀 𝘁𝗿𝗶𝗲𝗿 𝗹𝗮 𝗹𝗶𝘀𝘁𝗲 ? ╠══════════════════₪");
						System.out.println("1 - Année");
						System.out.println("2 - Titre");
						System.out.println("3 - Pays");
						System.out.println("4 - Tri Java (note)");
						System.out.println("5 - Tri séléction (note)");
						System.out.println("6 - Tri fusion (note)");
						System.out.println("7 - Annuler");

						System.out.print("Votre choix (entier) : ");

						triChoix = Clavier.lireInt();
						if (triChoix >= 1 && triChoix <= 6) {
							choixValide = true;
							choixValide2 = false;
							while (!choixValide2) {
								System.out.println(
										"₪═════════════════╣ 𝗗𝗮𝗻𝘀 𝗾𝘂𝗲𝗹 𝘀𝗲𝗻𝘀 𝘃𝗼𝘂𝗹𝗲𝘇 𝘃𝗼𝘂𝘀 𝘁𝗿𝗶𝗲𝗿 𝗹𝗮 𝗹𝗶𝘀𝘁𝗲 ? ╠══════════════════₪");
								System.out.println("1 - Croissant");
								System.out.println("2 - Decroissant");
								triSens = Clavier.lireInt();
								if (triSens >= 1 && triSens <= 2) {
									choixValide2 = true;
									startTime = System.nanoTime();
									Trier(triChoix, triSens);
									endTime = System.nanoTime();
									duration = endTime - startTime;
									System.out.println("temps : " + df.format(duration / 1000000.0) + "ms");
									System.out.println("");
									System.out.println("");
								} else {
									System.out.println("");
									System.out.println("Choix incorrect, veuillez essayer à nouveau.");
									System.out.println("");
								}
							}
						} else if (triChoix != 7) {
							System.out.println("");
							System.out.println("Choix incorrect, veuillez essayer à nouveau.");
							System.out.println("");
						} else {
							choixValide = true;
							choixValide2 = true;
						}
					}
					break;
				case 4:
					// Filtrer
					int typeFiltre;
					int choixFiltre;
					String motFiltre;
					choixValide = false;
					choixValide2 = false;
					choixValide3 = false;
					while (!choixValide) {
						System.out.println(
								"₪═════════════════╣ 𝗣𝗮𝗿 𝗾𝘂𝗼𝗶 𝘃𝗼𝘂𝗹𝗲𝘇 𝘃𝗼𝘂𝘀 𝗳𝗶𝗹𝘁𝗿𝗲𝗿 𝗹𝗮 𝗹𝗶𝘀𝘁𝗲 ? ╠══════════════════₪");
						System.out.println("1 - Titre");
						System.out.println("2 - Année");
						System.out.println("3 - Genre");
						System.out.println("4 - Pays");
						System.out.println("5 - Langue");
						System.out.println("6 - Réalisateur");
						System.out.println("7 - Scénariste");
						System.out.println("8 - Note");
						System.out.println("9 - Annuler");
						System.out.print("Votre choix (entier) : ");
						choixFiltre = Clavier.lireInt();
						if (choixFiltre >= 1 && choixFiltre <= 8) {
							choixValide = true;
							choixValide2 = false;
							choixValide3 = false;
							while (!choixValide2) {
								System.out.println(
										"₪═════════════════╣ 𝗤𝘂𝗲𝗹 𝘁𝘆𝗽𝗲 𝗱𝗲 𝗳𝗶𝗹𝘁𝗿𝗲 ? ╠══════════════════₪");
								System.out.println("1 - Linéaire");
								System.out.println("2 - Java");
								typeFiltre = Clavier.lireInt();
								if (choixFiltre >= 1 && choixFiltre <= 8) {
									choixValide = true;
									choixValide2 = true;
									choixValide3 = false;
									while (!choixValide3) {
										System.out.print("Entrez votre recherche (String) :");
										motFiltre = Clavier.lireLigne();
										startTime = System.nanoTime();
										if (choixFiltre == 1) {
											Filtre_lineaire(typeFiltre, motFiltre);
										} else {
											Filtre_Java(typeFiltre, motFiltre);
										}
										endTime = System.nanoTime();
										duration = endTime - startTime;
										System.out.println("temps : " + df.format(duration / 1000000.0) + "ms");
										choixValide3 = true;
									}
								}
							}
						} else if (choixFiltre != 9) {
							System.out.println("");
							System.out.println("Choix incorrect, veuillez essayer à nouveau.");
							System.out.println("");
						} else {
							choixValide = true;
							choixValide2 = true;
							choixValide3 = true;

						}
					}
					break;
				case 5:
					// Chercher
					int typeRecherche;
					String choixRecherche;
					choixValide = false;
					while (!choixValide) {
						System.out.println(
								"₪═════════════════╣ 𝗤𝘂𝗲𝗹 𝘁𝘆𝗽𝗲 𝗱𝗲 𝗿𝗲𝗰𝗵𝗲𝗿𝗰𝗵𝗲 ? ╠══════════════════₪");
						System.out.println(
								"(ATTENTION: vous devez trier la liste par TITRE CROISSANT avant de faire une recherche dichotomique)");
						System.out.println("1 - Linéaire");
						System.out.println("2 - Dichotomique");
						System.out.println("3 - Annuler");
						System.out.print("Votre choix (entier) : ");

						typeRecherche = Clavier.lireInt();
						if (typeRecherche >= 1 && typeRecherche <= 2) {
							choixValide = true;
							System.out.print("Entrez votre recherche (String)");
							choixRecherche = Clavier.lireLigne();
							startTime = System.nanoTime();
							if (typeRecherche == 1) {
								Recherche_lineaire(choixRecherche);
							} else {
								Recherche_dichotomique(choixRecherche);
							}
							endTime = System.nanoTime();
							duration = endTime - startTime;
							System.out.println("temps : " + df.format(duration / 1000000.0) + "ms");
							
						} else if (typeRecherche != 3) {
							System.out.println("");
							System.out.println("Choix incorrect, veuillez essayer à nouveau.");
							System.out.println("");
						} else {
							choixValide = true;
						}
					}
					break;
				case 6:
					int typeSauvegarde;
					choixValide = false;

					while (!choixValide) {
						System.out.println(
								"₪═════════════════╣ 𝗤𝘂𝗲𝗹 𝘁𝘆𝗽𝗲 𝗱𝗲 𝘀𝗮𝘂𝘃𝗲𝗴𝗮𝗿𝗱𝗲 ? ╠══════════════════₪");
						System.out.println(
								"(ATTENTION: vous devez trier la liste par TITRE CROISSANT avant de faire une recherche dichotomique)");
						System.out.println("1 - Fichier");
						System.out.println("2 - Binaire");
						System.out.println("3 - Annuler");
						System.out.print("Votre choix (entier) : ");

						typeSauvegarde = Clavier.lireInt();
						if (typeSauvegarde >= 1 && typeSauvegarde <= 2) {
							choixValide = true;
							startTime = System.nanoTime();
							sauvegarder(typeSauvegarde);
							endTime = System.nanoTime();
							duration = endTime - startTime;
							System.out.println("temps : " + df.format(duration / 1000000.0) + "ms");
						} else if (typeSauvegarde != 3) {
							System.out.println("");
							System.out.println("Choix incorrect, veuillez essayer à nouveau.");
							System.out.println("");
						} else {
							choixValide = true;
						}
					}
					break;
				case 7:
					startTime = System.nanoTime();
					Vider();
					System.out.println("La liste a été vidée.");
					endTime = System.nanoTime();
					duration = endTime - startTime;
					System.out.println("temps : " + df.format(duration / 1000000.0) + "ms");
					break;
				case 8:
					fini = true;
					break;

				default:
					System.out.println("Choix incorrect, réessayez.");
					System.out.println("");
					break;
			}
			System.out.println("");
		}
	}

	public static void ChargerFichier(int taille) throws IOException {
		BufferedReader fichier = null;
		String row = new String();

		if (taille == 80944) {
			fichier = new BufferedReader(new FileReader("IMDbmoviesFULL.tsv"));
		} else {
			fichier = new BufferedReader(new FileReader("IMDbmoviesCUT" + taille + ".tsv"));
		}

		row = fichier.readLine();
		while (row != null) {
			String[] Arrayrow = row.split("\t");
			if (!Arrayrow[1].equals("title")) {
				IMDbMovies.add(new Film(Arrayrow[1], Arrayrow[3], Arrayrow[4], Arrayrow[5], Arrayrow[6], Arrayrow[7],
						Arrayrow[8], Arrayrow[9], Arrayrow[10], Arrayrow[12], Arrayrow[13], Arrayrow[14],
						Arrayrow[15]));
			}
			row = fichier.readLine();
		}
		fichier.close();
	}

	public static void AfficherValeurs() {
		int i = 0;
		System.out.println("id   : " + exemple);
		if (IMDbMovies.size() <= 100) {
			Iterator<Film> it = IMDbMovies.iterator();
			while (it.hasNext()) {
				System.out.println(String.format("%-5s", i + 1) + ": " + it.next());
				i++;
			}
		} else {
			Iterator<Film> it = IMDbMovies.iterator();
			while (it.hasNext()) {
				if (i % (IMDbMovies.size() / 175) == 0) {
					System.out.println(String.format("%-5s", i + 1) + ": " + it.next());
				} else {
					it.next(); // Avancer l'itérateur
				}
				i++;
			}
		}
	}

	public static void Trier(int type, int ordre) {
		switch (type) {
			case 1:
				switch (ordre) {
					case 1:
						IMDbMovies.sort(Film.compareAnnee);
						break;
					case 2:
						IMDbMovies.sort(Film.reverseCompareAnnee);
						break;
				}
				break;
			case 2:
				switch (ordre) {
					case 1:
						IMDbMovies.sort(Film.compareTitle);
						break;
					case 2:
						IMDbMovies.sort(Film.reverseCompareTitle);
						break;
				}
				break;
			case 3:
				switch (ordre) {
					case 1:
						IMDbMovies.sort(Film.comparePays);
						break;
					case 2:
						IMDbMovies.sort(Film.reverseComparePays);
						break;
				}
				break;
			case 4:
				switch (ordre) {
					case 1:
						IMDbMovies.sort(Film.compareNote);
						break;
					case 2:
						IMDbMovies.sort(Film.reverseCompareNote);
						break;
				}
				break;
			case 5:
				switch (ordre) {
					case 1:
						triSelection();
						break;
					case 2:
						reverseTriSelection();
						break;
				}
				break;
			case 6:
				switch (ordre) {
					case 1:
						triFusion(0, IMDbMovies.size() - 1, false);
						break;
					case 2:
						triFusion(0, IMDbMovies.size() - 1, true);
						break;
				}
				break;				
		}
	}

	public static void Filtre_lineaire(int type, String mot) {
		Iterator<Film> it = IMDbMovies.iterator();
		switch (type) {
			case 1:
				while (it.hasNext()) {
					if (!Arrays.asList(it.next().title.split(" ")).contains(mot)) {
						it.remove();
					}
				}
				break;
			case 2:
				while (it.hasNext()) {
					if (!Arrays.asList(it.next().year.split(" ")).contains(mot)) {
						it.remove();
					}
				}
				break;
			case 3:
				while (it.hasNext()) {
					if (!Arrays.asList(it.next().genre.split(" ")).contains(mot)) {
						it.remove();
					}
				}
				break;
			case 4:
				while (it.hasNext()) {
					if (!Arrays.asList(it.next().country.split(" ")).contains(mot)) {
						it.remove();
					}
				}
				break;
			case 5:
				while (it.hasNext()) {
					if (!Arrays.asList(it.next().language.split(" ")).contains(mot)) {
						it.remove();
					}
				}
				break;
			case 6:
				while (it.hasNext()) {
					if (!Arrays.asList(it.next().writer.split(" ")).contains(mot)) {
						it.remove();
					}
				}
				break;
			case 7:
				while (it.hasNext()) {
					if (!Arrays.asList(it.next().director.split(" ")).contains(mot)) {
						it.remove();
					}
				}
				break;
			case 8:
				while (it.hasNext()) {
					if (!Arrays.asList(it.next().avg_vote.split(" ")).contains(mot)) {
						it.remove();
					}
				}
				break;
		}

	}

	public static void Filtre_Java(int type, String mot) {
		switch (type) {
			case 1:
				IMDbMovies.removeIf(f -> !f.title.contains(mot));
				break;
			case 2:
				IMDbMovies.removeIf(f -> !f.year.contains(mot));
				break;
			case 3:
				IMDbMovies.removeIf(f -> !f.genre.contains(mot));
				break;
			case 4:
				IMDbMovies.removeIf(f -> !f.country.contains(mot));
				break;
			case 5:
				IMDbMovies.removeIf(f -> !f.language.contains(mot));
				break;
			case 6:
				IMDbMovies.removeIf(f -> !f.director.contains(mot));
				break;
			case 7:
				IMDbMovies.removeIf(f -> !f.writer.contains(mot));
				break;
			case 8:
				IMDbMovies.removeIf(f -> !f.avg_vote.contains(mot));
				break;
		}

	}

	public static void Vider() {
		while (IMDbMovies.size() > 0) {
			IMDbMovies.remove(0);
		}
	}

	public static void Recherche_lineaire(String mot) {
		Iterator<Film> it = IMDbMovies.iterator();
		Film val = null, temp;

		while (it.hasNext() && val == null) {
			temp = it.next();
			if (temp.title.startsWith(mot)) {
				val = temp;
			}
		}
		if (val != null) {
			System.out.println(exemple);
			System.out.println(val);
		} else {
			System.out.println("Aucune valeur trouv e");
		}
	}

	public static void Recherche_dichotomique(String mot) {
		Film val = null, temp;
		int droite = IMDbMovies.size() - 1, gauche = 0;
		while (val == null && droite - gauche > 1) {

			temp = IMDbMovies.get(Math.round((droite + gauche) / 2));
			if (temp.title.startsWith(mot)) {
				val = temp;
			} else if (temp.title.compareTo(mot) > 0) {
				droite = Math.round((droite + gauche) / 2);
			} else {
				gauche = Math.round((droite + gauche) / 2);
			}
		}
		if (val == null) {
			if (IMDbMovies.get(droite).title.startsWith(mot)) {
				val = IMDbMovies.get(droite);
				System.out.println("a");
			} else if (IMDbMovies.get(gauche).title.startsWith(mot)) {
				val = IMDbMovies.get(gauche);
				System.out.println(("d"));
			}
		}

		if (val != null) {
			System.out.println(exemple);
			System.out.println(val);
		} else {
			System.out.println("Aucune valeur trouv e");
		}
	}

	public static void triSelection() {
		int min;
		Film temp;
		for (int i = 0; i < IMDbMovies.size() - 1; i++) {
			min = i;
			for (int j = i + 1; j < IMDbMovies.size(); j++) {
				try {
					float currentAvgVote = Float.parseFloat(IMDbMovies.get(j).avg_vote);
					float minAvgVote = Float.parseFloat(IMDbMovies.get(min).avg_vote);

					if (currentAvgVote < minAvgVote) {
						min = j;
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid avg_vote format for movie: " + IMDbMovies.get(j).title);
				}
			}
			temp = IMDbMovies.get(i);
			IMDbMovies.set(i, IMDbMovies.get(min));
			IMDbMovies.set(min, temp);
		}
	}

	public static void reverseTriSelection() {
		int max;
		Film temp;
		for (int i = 0; i < IMDbMovies.size() - 1; i++) {
			max = i;
			for (int j = i + 1; j < IMDbMovies.size(); j++) {
				if (Float.parseFloat(IMDbMovies.get(j).avg_vote) > Float.parseFloat(IMDbMovies.get(max).avg_vote)) {
					max = j;
				}
			}
			temp = IMDbMovies.get(i);
			IMDbMovies.set(i, IMDbMovies.get(max));
			IMDbMovies.set(max, temp);
		}
	}

	public static void triFusion(int g, int d, boolean reverse) {
		int n;

		if (d - g > 0) {
			n = (g + d) / 2;
			triFusion(g, n, reverse);
			triFusion(n + 1, d, reverse);
			fusionner(g, n, d, reverse);
		}

	}

	public static void fusionner(int g, int n, int d, boolean reverse) {
		Film[] tab2 = new Film[d - g + 1];
		int i = g;
		int j = n + 1;
		int k = 0;
		while (j <= d && i <= n) {
			if (((IMDbMovies.get(i).note <= IMDbMovies.get(j).note) && !reverse)
					|| (reverse && IMDbMovies.get(i).note >= IMDbMovies.get(j).note)) {
				tab2[k] = IMDbMovies.get(i);
				k++;
				i++;
			} else {
				tab2[k] = IMDbMovies.get(j);
				k++;
				j++;
			}
		}
		while (j <= d) {
			tab2[k] = IMDbMovies.get(j);
			k++;
			j++;
		}
		while (i <= n) {
			tab2[k] = IMDbMovies.get(i);
			k++;
			i++;
		}
		k = 0;
		while (k + g < d + 1) {
			IMDbMovies.set(k + g, tab2[k]);
			k++;
		}
	}

	public static void sauvegarder(int type) throws IOException {
		switch (type) {
			case 1:
				BufferedWriter writer = new BufferedWriter(new FileWriter("films.txt"));
				writer.write(exemple.toString());
				writer.newLine();
				for (Film film : IMDbMovies) {
					writer.write(film.toString());
					writer.newLine();
				}
				System.out.println("Les films ont été sauvegardés dans films.txt");
				break;
			case 2:
				ObjectOutputStream Fichier = new ObjectOutputStream(new FileOutputStream("stockage.bin"));
				Fichier.writeObject(IMDbMovies);
				Fichier.close();
				break;
		}
	}

}
