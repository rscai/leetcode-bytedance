#!/Users/rscai/anaconda3/bin/python
#
# Copyright 2014 Bernard Yue
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
from __future__ import unicode_literals, absolute_import

__prog__ = 'hanzi-convert'

import os, sys, codecs
import argparse
import textwrap
import warnings
from pathlib import Path
from hanziconv import HanziConv, __version__, __author__


class Main(object):
    def run(self):
        """program entry point"""
        args = self.parseArgs()
        self.args = args
        self.processFolder(args.infile, args.outfile, args.simplified)

    def parseArgs(self):
        """parsing input arguments

        :returns :       a parser.parse_arg() object
        """
        desc = textwrap.dedent("""\
                Simplified and Traditional Chinese Character Conversion
                Version {} (By {})

                Converting to Traditional Hanzi by default
                """.format(__version__, __author__))
        parser = argparse.ArgumentParser(prog=__prog__,
                formatter_class=argparse.RawDescriptionHelpFormatter,
                description=desc)
        parser.add_argument('infile', type=str,
                help='filename | "-", corresponds to stdin')
        parser.add_argument('-o', '--output', dest='outfile',
                default='',
                help='filename to save output, default to stdout')
        parser.add_argument('-s', '--simplified', action='store_true',
                help='convert to simplified')
        parser.add_argument('-v', '--version', action='version',
                version='%(prog)s Version ' + __version__)
        return parser.parse_args()
    def processFolder(self, infolder, outfolder, simplified):
        files = list(Path(infolder).rglob("*.md"))
        for infile in files:
            outfile = str(infile).replace(infolder, outfolder)
            self.process(infile,outfile, simplified)
            print("Converted "+str(infile)+" to Chinese simplified "+outfile)
    def process(self, infile, outfile, simplified):
        """Application workflow

        :params infile:     name of input file ('-' for stdin)
        :params outfile:    name of output file ('' for stdout)
        :params simplified: bool flag.  True -- convert to Simplified Text
                            False -- otherwise
        :returns :          None
        """
        data = self.read(infile)
        func = HanziConv.toTraditional
        if simplified:
            func = HanziConv.toSimplified
        converted = ''
        for line in data:
            converted += func(line)
        self.write(converted, outfile)

    def read(self, filename):
        """Read content from filename, and stdin if filename = '-'

        :params filename: name of input file ('-' for stdin)
        :returns :        html as string
        """
        encoding = 'utf-8'
        with warnings.catch_warnings():
            warnings.simplefilter("ignore")
            if filename == '-':
                filename = ''
                sys.stderr.write('Press Ctrl-D with finished' + os.linesep)
                sys.stderr.flush()

        if sys.version >= '3':
            data = self.py3GetData(filename)
        else:
            data = self.py2GetData(filename)
        return data

    def py2GetData(self, filename):
        """read all unicode data from file for python 2.x.  Return all data
        in `filename` as `encoding`

        :params filename: name of input file ('-' for stdin)
        :returns :        data in
        """
        encoding = 'utf-8'
        data = ''
        if filename:
            with open(filename, 'rU') as fh:
                fh = codecs.getreader(encoding)(fh)
                data = fh.read()
        else:
            sys.stdin = codecs.getreader(encoding)(sys.stdin)
            data = sys.stdin.read()
        return data

    def py3GetData(self, filename):
        """read all unicode data from file for python 3.x.  Return all data
        in `filename` as `encoding`

        :params filename: name of input file ('-' for stdin)
        :returns :        data in
        """
        encoding = 'utf-8'
        data = ''
        if filename:
            with open(filename, 'r', encoding=encoding) as fh:
                data = fh.read()
        else:
            data = sys.stdin.read()
        return data

    def write(self, data, filename):
        """write `data` to `filename`, if 'filename` is '', write to stdout

        :params data:       (multiline) string to write to `filename`
        :params filename:   name of output file ('' for stdout)
        :returns :          None
        """
        if sys.version >= '3':
            self.py3WriteData(data, filename)
        else:
            self.py2WriteData(data, filename)

    def py2WriteData(self, data, filename):
        """write unicode to file, python 2.x version

        :params data:       (multiline) string to write to `filename`
        :params filename:   name of output file ('' for stdout)
        :returns :          None
        """
        if filename:
            with codecs.open(filename, 'wU', encoding='utf-8') as fh:
                fh.write(data)
        else:
            sys.stdout = codecs.getwriter("utf-8")(sys.stdout)
            sys.stdout.write(data)
            sys.stdout.flush()

    def py3WriteData(self, data, filename):
        """write unicode to file, python 3.x version

        :params data:       (multiline) string to write to `filename`
        :params filename:   name of output file ('' for stdout)
        :returns :          None
        """
        if filename:
            with open(filename, 'w', encoding='utf-8') as fh:
                fh.write(data)
        else:
            sys.stdout.write(data)
            sys.stdout.flush()


if __name__ == '__main__':
    Main().run()