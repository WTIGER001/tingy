package org.bauer.tinyg.cmd;

import java.util.Scanner;

import org.bauer.tingy.TinyG;

public class Main {
	private static String prompt = "TinyG> ";
	private static Commands commands = new Commands();

	public static void main(String[] args) {

		// Parse the command line. We are looking for the verbose flag and the
		// logging path / level
		// TODO: INITIAL CONFIGURATION

		System.out.println("Welcome to the TinyG Command line. type 'help' for command help.");

		// Initialize the tiny g threads
		TinyG.init();

		CommandContext ctx = new CommandContext();

		// Listen for Commands
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print(prompt);
			while (true) {
				// Read the line of input
				String line = scanner.nextLine();

				// Parse the command
				try {
					commands.execCommand(line, ctx);
				} catch (InvalidCommandException e) {
					System.err.println("   Error: " + e.getMessage());
					System.err.flush();
				} finally {
					System.out.print(prompt);
				}
			}
		}

	}

}
