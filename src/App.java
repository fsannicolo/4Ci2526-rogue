public class App {
    public static void main(String[] args) throws Exception {
        
        //Room r1 = new Room(null);
        Room r2 = new BossRoom(null);
        Room r3 = new ChallengeRoom(null);
        BossRoom r4 = new SuperBossRoom(null);
        Object r5 = new ChallengeRoom(null);
        //BossRoom r6 = new ChallengeRoom(null);
        Object r7 = new BossRoom(null);
        //SuperBossRoom r8 = (SuperBossRoom)new BossRoom(null);

        r2.identify();
        //((BossRoom)r3).identify(); errore!
        System.out.println("---");
        r4.identify();
        System.out.println("---");
        ((ChallengeRoom)r5).identify();

        if (r7 instanceof BossRoom br7)
            br7.identify();

        
    }
}
