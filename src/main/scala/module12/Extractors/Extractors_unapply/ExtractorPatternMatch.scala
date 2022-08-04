package module12.Extractors.Extractors_unapply

object ExtractorPatternMatch extends App {
                val x = ExtractorPatternMatch(25)

                // Displays output of the
                // Apply method
                println(x)

                // Applying pattern matching
                x match
                        {
                        // unapply method is called
                        case ExtractorPatternMatch(y) => println("The value is: "+y)
                                case _ => println("Can't be evaluated")
                        }

                def apply(x: Double): Double = x / 5

                // Defining unapply method
                        def unapply(z: Double): Option[Double] =

                        if (z % 5 == 0)
                                {
                                        Some(z/5)
                                        }

                                else None
                }
