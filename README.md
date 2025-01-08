# Playlist Manager

A Java application that simulates a playlist manager.  You can create albums, add songs to albums, and build a playlist from those albums.  The app allows you to navigate through the playlist, replay songs, and view the list of songs in the playlist.

## Features

- Add songs to albums with a title and duration.
- Create a playlist from songs in the albums.
- Navigate the playlist:
  - Play the next or previous song.
  - Replay the current song.
  - View all songs in the playlist.
- Simple command-line interface for interacting with the playlist.

## Technologies Used

- **Java**
  - Utilizes `ArrayList` for storing songs in an album.
  - Uses `LinkedList` for managing the playlist.
  - Implements `ListIterator` for seamless forward and backward traversal of the playlist.
 
## Code Overview
1. Song Class
- The `Song` class represents a single song with:
  - A `title` (e.g., "Blank Space").
  - A `duration` (e.g., 3.51 minutes).
  - A `toString` method for easy display of song details.

2. Album Class
- The `Album` class:
  - Stores a collection of `Song` objects.
  - Allows adding songs to the album.
  - Includes methods to add songs to a playlist:
    - By song title.
    - By track number.

3. Main Class
- The `Main` class:
  - Creates albums and add songs to them.
  - Builds a playlist from the albums.
  - Provides a `play()` method to navigate the playlist with options like:
    - Playing the next or previous song.
    - Replaying the current song.
    - Displaying all songs in the playlist.

## Example
### Sample Albums and Playlist

- Albums:
1. **Thriller** by Michael Jackson
   - Thriller (5.57)
   - Billie Jean (4.54)
   - Beat It (4.18)
2. **1989** by Taylor Swift
   - Blank Space (3.51)
   - Style (3.51)
   - Shake It Off (3.39)

- Playlist:
  - Thriller
  - Billie Jean
  - Style
  - Shake It Off

## Console Interaction
When you run the program, the following menu will be displayed:

```plaintext
Available actions:
Press
0 - to quit
1 - to play next song
2 - to play previous song
3 - to replay the current song
4 - list songs in the playlist
5 - print menu options
```
Use the menu options to navigate and interact with the playlist.
