namespace Solution
{
    internal class Program
    {
        static int min = 0, max = 0;
        static void Main(string[] args)
        {

            int[] array = new int[7] { 4, 9, 6, 20, 5, 2, 3 };
            GetMinAndMax(array);
            Console.WriteLine($"Max number is {max}");
            Console.WriteLine($"Min number is {min}");
        }
        static void GetMinAndMax(int[] array)
        {
            int i = 0, j = 1;
            min = array[i];
            max = array[i];
            while (j < array.Length)
            {
                if (array[i] < array[j])
                {
                    max = Math.Max(max, array[j]);
                    min = Math.Min(min, array[i]);
                }
                else
                {
                    max = Math.Max(max, array[i]);
                    min = Math.Min(min, array[j]);
                }
                i += 2;
                j += 2;
            }
            if (i < array.Length)
            {
                max = Math.Max(max, array[i]);
                min = Math.Min(min, array[i]);
            }
        }
    }
}
