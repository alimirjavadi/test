package com.example.testexam1;

public class Templistitem  {
        private final String[] name = {
                "Emily",
                "James",
                "Sophia",
                "James",
                "Sophia",
                "James",
                "Sophia",
                "William"
        };
        private final int[] avatar = {
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground
        };

      public String[] getname() {
          return name;
        }

        public int[] getavatar(){
          return avatar;
        }
    }
