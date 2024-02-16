package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1873_배틀필드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            char[][] MAP = new char[H][W];

            int x = 0;
            int y = 0;
            int dir = 0;
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int j = 0; j < W; j++) {
                    MAP[i][j] = s.charAt(j);
                    if (MAP[i][j] == '^' || MAP[i][j] == '>' || MAP[i][j] == 'v' || MAP[i][j] == '<') {
                        x = i;
                        y = j;
                        switch (MAP[i][j]) {
                            case '^': {
                                dir = 0;
                                break;
                            }
                            case '>': {
                                dir = 1;
                                break;
                            }
                            case 'v': {
                                dir = 2;
                                break;
                            }
                            case '<': {
                                dir = 3;
                                break;
                            }
                            default:
                                continue;
                        }
                    }
                }
            }
            st = new StringTokenizer(br.readLine());

            int len = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            char[] ACTIVE = st.nextToken().toCharArray();
            for (int i = 0; i < len; i++) {
                switch (ACTIVE[i]) {
                    case 'U': {
                        dir = 0;
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        if (rangeCheck(nx, ny, H, W, MAP) && MAP[nx][ny] == '.') {
                            MAP[x][y] = '.';
                            x = nx;
                            y = ny;
                        }
                        MAP[x][y] = '^';
                        break;
                    }
                    case 'R': {
                        dir = 1;
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        if (rangeCheck(nx, ny, H, W, MAP) && MAP[nx][ny] == '.') {
                            MAP[x][y] = '.';
                            x = nx;
                            y = ny;
                        }
                        MAP[x][y] = '>';
                        break;
                    }
                    case 'D': {
                        dir = 2;
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        if (rangeCheck(nx, ny, H, W, MAP) && MAP[nx][ny] == '.') {
                            MAP[x][y] = '.';
                            x = nx;
                            y = ny;
                        }
                        MAP[x][y] = 'v';
                        break;
                    }
                    case 'L': {
                        dir = 3;
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        if (rangeCheck(nx, ny, H, W, MAP) && MAP[nx][ny] == '.') {
                            MAP[x][y] = '.';
                            x = nx;
                            y = ny;
                        }
                        MAP[x][y] = '<';
                        break;
                    }
                    case 'S': {
                        int boomX = x + dx[dir];
                        int boomY = y + dy[dir];
                        while (rangeCheck(boomX, boomY, H, W, MAP) && MAP[boomX][boomY] != '#') {
                            if (MAP[boomX][boomY] == '*') {
                                MAP[boomX][boomY] = '.';
                                break;
                            }
                            boomX = boomX + dx[dir];
                            boomY = boomY + dy[dir];
                        }
                        break;
                    }
                    default:
                        continue;
                }
            }

            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(MAP[i][j]);
                }
                sb.append("\n");
            }

//            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);

    }

    private static boolean rangeCheck(int x, int y, int H, int W, char[][] map) {
        return (x >= 0 && x < H) && (y >= 0 && y < W);
    }
}
