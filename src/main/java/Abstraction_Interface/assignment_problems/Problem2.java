public class Problem2 {
    public static void main(String[] args) {
        Painting p = new Painting("Sunset Fields");
        Sculpture s = new Sculpture("The Thinker II");

        System.out.println(p.describe());
        System.out.println("Piece ID: " + p.getPieceId());

        System.out.println(s.describe());
        System.out.println("Piece ID: " + s.getPieceId());
    }
}
