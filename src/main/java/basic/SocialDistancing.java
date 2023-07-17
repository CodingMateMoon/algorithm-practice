package basic;

public class SocialDistancing {

    private static final int[] dx = {0, -1, 1, 0};
    private static final int[] dy = {-1, 0, 0, 1};

    private static boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
        for (int d = 0; d < 4; d++) {
            if (d == exclude)
                continue;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length)
                continue;
            if (room[ny][nx] == 'P') {
                return true;
            }
        }
        return false;
    }
    private static boolean isDistanced(char[][] room, int x, int y) {

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length)
                continue;
            char c = room[ny][nx];
            if (c == 'P') {
                return false;
            }
            if (c == 'O') {
                if(isNextToVolunteer(room, nx, ny, 3 - d))
                    return false;
            }
        }
        return true;
    }

    public static boolean isDistanced(char[][] room) {

        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if (room[y][x] == 'P') {
                    if (!isDistanced(room, x, y)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int[] solution(String[][] places) {
        int[] result = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for (int y = 0; y < room.length; y++) {
                room[y] = place[y].toCharArray();
            }
            if(isDistanced(room)) {
                result[i] = 1;
                continue;
            }
            result[i] = 0;
        }

        return result;
    }






}
